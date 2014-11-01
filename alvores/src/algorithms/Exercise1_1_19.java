package algorithms;

public class Exercise1_1_19 {

		public static long F(int N) {
			if (N == 0) return 0;
			if (N == 1) return 1;
			return F(N-1) + F(N-2);
		}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int nloop = 40;
		for (int N = 0; N < nloop; N++) {
			System.out.println(N + " " + F(N));
		}
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		System.out.printf("n=%d, time=%d%n", nloop, totalTime);

	}

}
