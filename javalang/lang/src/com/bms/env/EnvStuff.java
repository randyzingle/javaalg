package com.bms.env;

import java.util.Map;

public class EnvStuff {

	public static void main(String[] args) {
		// first print out the command line arguments
		System.out.println("Command line args: ");
		for (String s: args) {
			System.out.println(s);
		}
		System.out.println("Environment variables: ");
		Map<String, String> env = System.getenv();
		for (String key: env.keySet()) {
			System.out.format("%s=%s%n", key, env.get(key));
		}
	}

}
