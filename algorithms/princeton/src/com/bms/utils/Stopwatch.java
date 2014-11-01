package com.bms.utils;

public class Stopwatch {
	private long startTime = 0L;
	private long endTime = 0L;
	
	public Stopwatch() {
		start();
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public double getElapsedTimeInSecs() {
		endTime = System.currentTimeMillis();
		double time = (endTime - startTime) / 1000.0;
		return time;
	}
}
