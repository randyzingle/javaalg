package com.bms.env;

import java.util.Map;

public class EnvStuff {

	public static void main(String[] args) {
		// first print out the command line arguments
		System.out.println("Command line args: ");
		for (String s: args) {
			System.out.println(s);
		}
		// print out the env variables - note eclipse does NOT read your .bash_profile
		System.out.println("Environment variables: ");
		Map<String, String> env = System.getenv();
		for (String key: env.keySet()) {
			System.out.format("%s=%s%n", key, env.get(key));
		}
	}

}
