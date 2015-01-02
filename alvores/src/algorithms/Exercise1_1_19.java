package algorithms;

import java.util.Arrays;

public class Exercise1_1_19 {

		public static long F(int N) {
			if (N == 0) return 0;
			if (N == 1) return 1;
			return F(N-1) + F(N-2);
		}
		
		public static long iterativeFibonacci(int N) {
			// index 0 1 2 3
			// value 0 1 1 2
			if (N == 0) {
				return 0;
			} else if (N == 1) {
				return 1;
			}
			
			long[] dstor = new long[N];
			for (int i = 0; i < N; i++) {	
				if (i == 0) {
					dstor[i] = 0;
				} else if (i == 1) {
					dstor[i] = 1;
				} else {
					dstor[i] = dstor[i-1] + dstor[i-2];
				}
//				System.out.println(Arrays.toString(dstor));	
			}	
			System.out.println(Arrays.toString(dstor));	
			return dstor[N-1]; 
		}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int nloop = 40;
//		iterativeFibonacci(4);
		for (int N = 0; N < nloop; N++) { // Needs to have an incriment from...
			System.out.println(N + " " + iterativeFibonacci(N));
		}
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		System.out.printf("n=%d, time=%d%n", nloop, totalTime);

	}

}
