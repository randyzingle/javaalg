
public class PercolationStats {
	
	private double[] p;
	private int t;
	private int n;
	private final boolean DEBUG = false;

	public static void main(String[] args) {
		// read n (grid size) and t (number of simulations)
		int n = Integer.parseInt(args[0]);
		int t = Integer.parseInt(args[1]);
		new PercolationStats(n, t);
	}
	
	private int getArrayIndex(int i, int j) {
		int x = (i-1)*n + j - 1;
		return x;
	}
	
	/**
	 * Run a series of t percolation tests on an n * n grid of cells
	 * @param n build and n * n grid off cells, all originally blocked
	 * @param t number of times to run the simulation 
	 */
	public PercolationStats(int n, int t) {
		if (n <=0 || t<=0) throw new IllegalArgumentException("n and t must be > 0");
		this.t = t;
		this.n = n;
		if(DEBUG)System.out.printf("n=%d, t=%d%n", n,t);
		
		// run the experiment t times, p is the percolation threshold
		p = new double[t];
		for (int k=0; k<t; k++) {
			if(DEBUG)System.out.printf("iteration %d%n", k);
			// create a new percolation grid
			Percolation perc = new Percolation(n);
			// open cells until the grid percolates
			// keep track of the cells we've tried to open in cand
			// track number of cells opened in cnt
			int cnt = 0;
			int[] cand = new int[n*n];
			while(!perc.percolates()) {
				int i = StdRandom.uniform(n) + 1;
				int j = StdRandom.uniform(n) + 1;
				int h = getArrayIndex(i, j);
				// only try to open blocked cells
				if(cand[h] == 1) continue;
				cand[h] = 1;
				cnt++;
				perc.open(i, j);
			}
			p[k] = 1.0*cnt/(n*n);
			if(DEBUG)System.out.printf("p[%d]=%1.8f%n", k, p[k]);
		}

		StdOut.printf("mean = %1.16f%n", mean());
		StdOut.printf("stddev = %1.16f%n", stddev());
		StdOut.printf("95%% confidence interval = %1.16f,  %1.16f%n", confidenceLo(), confidenceHi());
	}
	
	/**
	 * Sample mean of the percolation threshold
	 * @return Sample mean of the percolation threshold
	 */
	public double mean() {
		return StdStats.mean(p);
	}
	
	/**
	 * Sample standard deviation of percolation threshold
	 * @return Sample standard deviation of percolation threshold
	 */
	public double stddev() {
		return StdStats.stddev(p);
	}
	
	/**
	 * 
	 * @return low end point of 95% confidence interval
	 */
	public double confidenceLo() {
		double mean = mean();
		double stddev = stddev();
		return mean - (1.96*stddev)/Math.sqrt(t);
	}
	
	/**
	 * 
	 * @return high end point of 95% confidence interval
	 */
	public double confidenceHi() {
		double mean = mean();
		double stddev = stddev();
		return mean + (1.96*stddev)/Math.sqrt(t);
	}

}
