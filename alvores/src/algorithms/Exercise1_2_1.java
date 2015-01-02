package algorithms;

import java.awt.geom.Point2D;
import java.util.Scanner;
import java.util.Random;

public class Exercise1_2_1 {
	public static void main(String[] args) {
		Random rand = new Random();

		Scanner input = new Scanner(System.in);
		int n = 0;
		int distance;

		if (n <= 0) {
			System.out.println("Enter a value for N: "); // Number of random
															// points
			n = input.nextInt();
			input.close();
		}

		Point2D.Double[] pointArray = new Point2D.Double[n];

		for (int i = 0; i < n; i++) {
			double x = rand.nextDouble() * 10;
			double y = rand.nextDouble() * 10;
			Point2D.Double psd = new Point2D.Double(x, y);
			pointArray[i] = psd;

		}

		double smallDistance = Double.MAX_VALUE;

		for (int j = 0; j < pointArray.length - 1; j++) {
			for (int i = j + 1; i < pointArray.length; i++) {
				Point2D.Double one = pointArray[j];
				Point2D.Double two = pointArray[i];
				double d = one.distance(two);
				if (d < smallDistance) {
					smallDistance = d;
				}
//System.out.printf("j=%d, i=%d%n",j,i);
			}
		}
		System.out.println("The smallest distance is: " + smallDistance);

	}
}
