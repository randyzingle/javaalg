
public class Percolation {
	
	private int n; // n * n grid
	private int[] grid; // n^2 cells of the grid: 0=blocked, 1=open
	private WeightedQuickUnionUF uf;
	private final boolean DEBUG=false;
	private boolean percolates = false;
	private double nopen = 0.0;
	
	private int getArrayIndex(int i, int j) {
		int x = (i-1)*n + j - 1;
		return x;
	}
	
	/**
	 * grid[n] = 0 // blocked cell
	 * grid[n] = 1 // open cell
	 * @param create an n * n grid of cells that are initially all open
	 */
	public Percolation(int n) {
		if (n <=0) throw new IllegalArgumentException();
		grid = new int[n*n];
		this.n = n;
		uf = new WeightedQuickUnionUF(n*n);
		// union all top row squares to a virtual root at 0 (top left corner)
		for (int k=0; k<n-1; k++) {
			uf.union(k, k+1);
		}
		// union all bottom row squares to a virtual root at n^2-n (bottom left corner)
		for (int k=(n*n)-n; k<(n*n)-1; k++) {
			uf.union(k, k+1);
		}
	}
	
	public void open(int i, int j) {

		if ( !(i>=1 && i<=n) || !(j>=1 && j<=n)) {
			throw new IndexOutOfBoundsException("Index out of bounds i="+i+" j="+j);
		}
		if (!isOpen(i,j)) {
			nopen++;
			// open site (row i, column j) if it is not already open
			int cell = getArrayIndex(i, j);
			if (DEBUG) {System.out.printf("Opening %d, %d cell: %d%n", i, j, cell);}
			grid[cell] = 1;
			// union with any open, adjacent cells
			
			// try top cell unless we are at the top (i = 1)
			if (i != 1) {
				if(DEBUG) System.out.println("try top cell");
				// is the cell open?
				if (isOpen(i-1, j)) {
					// if it is open, connect it unless they are already connected
					int tcell = getArrayIndex(i-1, j);
					if (!uf.connected(cell, tcell)) {
						uf.union(cell, tcell);
						if(DEBUG) System.out.printf("union %d, %d%n", cell, tcell);
					}
				}
			}
			
			// try the right cell unless we are in the right most column (j=n)
			if (j != n) {
				if(DEBUG) System.out.println("try right cell");
				// is the cell open?
				if (isOpen(i, j+1)) {
					// it is open, connect it unless they are already connected
					int tcell = getArrayIndex(i, j+1);
					if (!uf.connected(cell, tcell)) {
						uf.union(cell, tcell);
						if(DEBUG) System.out.printf("union %d, %d%n", cell, tcell);
					}
				}
			}
			
			// try the bottom cell unless we are in the bottom row (i=n)
			if (i != n) {
				if(DEBUG) System.out.println("try bottom cell");
				// is the cell open?
				if (isOpen(i+1, j)) {
					// it is open, connect it unless they are already connected
					int tcell = getArrayIndex(i+1, j);
					if (!uf.connected(cell, tcell)) {
						uf.union(cell, tcell);
						if(DEBUG) System.out.printf("union %d, %d%n", cell, tcell);
					}
				}
			}
			
			// try the left cell unless we are in the left column (j=1)
			if (j != 1) {
				if(DEBUG) System.out.println("try left cell");
				// is the cell open?
				if (isOpen(i, j-1)) {
					// it is open, connect it unless they are already connected
					int tcell = getArrayIndex(i, j-1);
					if (!uf.connected(cell, tcell)) {
						uf.union(cell, tcell);
						if(DEBUG) System.out.printf("union %d, %d%n", cell, tcell);
					}
				}
			}
			
			// check to see if we have percolated 
			// this cell is connected to the top (full) and bottom rows
			if (isFull(i, j) && uf.connected(cell, n*n-1)) percolates = true;

		}
	}
	
	public boolean isOpen(int i, int j) {
		if ( !(i>=1 && i<=n) || !(j>=1 && j<=n)) {
			throw new IndexOutOfBoundsException("Index out of bounds i="+i+" j="+j);
		}
		int val = this.getArrayIndex(i, j);
		if(DEBUG)System.out.printf("checking for open %d,%d = %b%n", i,j,grid[val] == 1);
		return grid[val] == 1;
	}
	
	public boolean isFull(int i, int j) {
		if ( !(i>=1 && i<=n) || !(j>=1 && j<=n)) {
			throw new IndexOutOfBoundsException("Index out of bounds i="+i+" j="+j);
		}
		if (!isOpen(i,j)) return false;
		boolean full = uf.connected(getArrayIndex(i, j), 0);
		if(DEBUG)System.out.printf("is cell %d,%d full = %b%n",i,j,full);
		return full;
	}
	
	public boolean percolates() {
		// the grid percolates if we are in the bottom row and the cell is full
		// instead of checking in this method we will check each time we open a cell
		// that way we don't have the scan across the bottom row
		return this.percolates;
	}

	public static void main(String[] args) {
		int n = 5;
		Percolation p = new Percolation(n);	
		int b = 0;
		int[] rnd = new int[n*n];
		// now randomly open cells and check to see if grid percolates
		while (!p.percolates) {
			int i = StdRandom.uniform(n) + 1;
			int j = StdRandom.uniform(n) + 1;
			int k = p.getArrayIndex(i, j);
			if (rnd[k] == 1) continue;
			rnd[k] = 1;
			b++;
			if (b > 200) break;

//			System.out.printf("trying cell %d, %d%n", i,j);
			p.open(i, j);
			System.out.println("percolates = " + p.percolates);
			p.printGridValue();
			
			if (p.percolates) {
				System.out.println(b + " times through loop");
				System.out.println("percolation threshold: " + p.nopen/(n*n));
				System.out.println(1.0*b / (n*n));
				break;
			}
		}
		
	}
	
	private void printGridValue() {
		System.out.println("n: " + n);
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				System.out.printf("%d ", grid[getArrayIndex(i,j)]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
