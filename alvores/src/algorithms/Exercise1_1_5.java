package algorithms;

import java.util.Scanner;

// This program prompts the user for two numbers.
// Then the program determines if both numbers are between 0 and 1.
// If both numbers are between 0 and 1 the result is TRUE.
// Otherwise the result FALSE is given.

public class Exercise1_1_5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double x;
		double y;
		boolean b;
		
		System.out.println("Enter a value for X: ");	
		x = input.nextDouble();
		System.out.println("Enter a value for Y: ");
		y = input.nextDouble();
		input.close();
		
		b = test(x, y);
		
		if (b) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

	}
	
	public static boolean test(double x, double y) {
		boolean a = false;
		
		if (x < 1 && x > 0 && y < 1 && y > 0) {
			a = true;
			return a;
		} else {
			return a;
		}
	}

}

