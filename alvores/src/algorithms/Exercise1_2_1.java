package algorithms;

import java.awt.geom.Point2D;
import java.util.Scanner;
import java.util.Random;

public class Exercise1_2_1 {
	public static void main(String[] args) {
		Random rand = new Random();

		Scanner input = new Scanner(System.in);
		int n;
		int distance;

		System.out.println("Enter a value for N: "); // Number of random points
		n = input.nextInt();
		input.close();
		
		Point2D.Double[] pointArray = new Point2D.Double[n];

		for (int i = 0; i < n; i++) {
			double x = rand.nextInt();
			double y = rand.nextInt();
			Point2D.Double psd = new Point2D.Double(x, y);
			pointArray[i] = psd;
		}
		
		for (int i = 0; i < n; i++) {
			distance(double px, double py);
		}
		//distance(double px, double py)
		//Returns the distance from this Point2D to a specified point.
		

	}
}
