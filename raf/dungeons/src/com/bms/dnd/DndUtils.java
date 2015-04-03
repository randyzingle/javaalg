package com.bms.dnd;
import java.util.*;

public class DndUtils {
	
	public static int rollDice(int numberOfSides, int numberOfDice) {

		Random r = new Random(); 
		int sum = 0;
		for (int i=0; i <= numberOfDice; i++){
			sum = sum + r.nextInt(numberOfSides)+1;
		}
		
		return sum;
	}

}
