package algorithms;

public class Exercise1_1_19 {

		public static long F(int N) {
			if (N == 0) return 0;
			if (N == 1) return 1;
			return F(N-1) + F(N-2);
		}
		
		public static long iterativeFibonacci(int N) {
			long[] dstor = new long[N];
			
			return 0L;
		}
	
	public static void main(String[] args) {
		for (int N = 0; N < 100; N++) {
			System.out.println(N + " " + F(N));
		}

	}

}