package com.bms.lambda;

public class Lambda1 {

	public static void main(String[] args) {
		Runnable r = () -> System.out.println("Hello Lambda");
		r.run();
	}

}
