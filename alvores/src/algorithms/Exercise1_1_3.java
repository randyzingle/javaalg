package algorithms;

import java.util.Scanner;

public class Exercise1_1_3 {
	
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	
	int a; 
	int b;
	int c;
	
	System.out.println("Enter a value for A: ");	
	a = input.nextInt();
	System.out.println("Enter a value for B: ");
	b = input.nextInt();
	System.out.println("Enter a value for C: ");
	c = input.nextInt();
	input.close();
	
	if (a == b) {
		if (a == c) {
			System.out.println("All values are equal.");
		} else {
			System.out.println("All values are not equal.");
		}
	} else {
		System.out.println("All values are not equal.");
	}
	
	}
}
