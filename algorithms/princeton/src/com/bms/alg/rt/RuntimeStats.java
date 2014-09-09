package com.bms.alg.rt;

public class RuntimeStats {

	public static void main(String[] args) {
		try {
			RuntimeStats rs = new RuntimeStats();
			rs.compSpeedStats();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void compSpeedStats() {
		long st = System.currentTimeMillis();
		long nloop = (long)Math.pow(10, 8);
		int n = (int)nloop;
		System.out.println(nloop);
		double b = 0;
		double a = 12;
		Runtime runtime = Runtime.getRuntime();
		long onem = 1000000;
		long freem = runtime.freeMemory() / onem;
		long maxm = runtime.maxMemory() / onem;
		long totm = runtime.totalMemory() / onem;
		System.out.println("Max mem: " + maxm + ", Free mem: " + freem + ", Tot mem: " + totm);
		double[] ar = new double[n];	
		double[] ar2 = new double[(int)onem*70];
		System.out.println("Max mem: " + maxm + ", Free mem: " + freem + ", Tot mem: " + totm);
		String s1 = "aaaaaa the end of times";
		String s2 = "bbbbbb the start of times";
		String s3 = "";
		for (long i=0; i<nloop; i++) {
//			s3 = s1 + s2;
		}

		long et = System.currentTimeMillis();
		double rt = (et - st) ;
		System.out.println(b);
		System.out.println("Total runtime: " + rt + " msecs");
		
	}

}
