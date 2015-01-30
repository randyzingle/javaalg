package com.jbergin.robot;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** The robot world. Knows where the beepers are as well as the walls. 
 * TODO make it learn the locations of all robots
 * @author jbergin
 *
 */
public class World {
	
	public static final int INFINITE = -1;
	
	private Map<Point, Integer> beepers = new HashMap<Point, Integer>();
	private Set<Point> eastWestWalls = new HashSet<Point>();
	private Set<Point> northSouthWalls = new HashSet<Point>();
	
	/** Place a single beeper at a specific corner
	 * @param street the street on which to place the beeper
	 * @param avenue the avenue on which to place the beeper
	 */
	public void placeBeeper(int street, int avenue){
		Point where = new Point(street, avenue);
		Integer howMany = beepers.get(where);
		if(howMany == null){
			beepers.put(where, 1);
		} else {
			beepers.put(where, howMany+1);
		}
	}
	
	/** Remove a single beeper from a corner. Throws and exception if 
	 * there is no beeper
	 * there
	 * @param street the street from which to remove the beeper
	 * @param avenue the avenue from which to remove the beeper
	 */
	public void removeBeeper(int street, int avenue) {
		Point where = new Point(street, avenue);
		Integer howMany = beepers.get(where);
		if(howMany != null){
			if(howMany == 1){
				beepers.remove(where);
			} else{
				beepers.put(where, howMany = 1);
			}	
		} else {
			throw new RuntimeException("Tried to remove beepers from world where there were none.");
			// should not be thrown. Robots should catch this. 
		}
	}

	/** Place a single wall segment north of a given corner
	 * @param northOfStreet the street just below the new wall
	 * @param blockingAvenue the avenue that will be blocked
	 */
	public void placeWallEastWest(int northOfStreet, int blockingAvenue){
		eastWestWalls.add(new Point(northOfStreet, blockingAvenue));		
	}
	
	/** Place a single wall segment east of a given corner
	 * @param blockingStreet the street that will be blocked
	 * @param eastOfAvenue the avenue just west of the new wall
	 */
	public void placeWallNorthSouth(int blockingStreet, int eastOfAvenue){
		northSouthWalls.add(new Point(blockingStreet, eastOfAvenue));
	}
	
	/** Determine if there is a wal just East of a given corner
	 * @param street the street of the corner
	 * @param avenue the avenue of the corner
	 * @return true if there is a wall just East of this corner
	 */
	public boolean wallOnStreetEastOf(int street, int avenue){
		return northSouthWalls.contains(new Point(street, avenue));
	}
	
	/** Determine if there is a wall just West of this corner
	 * @param street the street of the corner
	 * @param avenue the avenue of the corner
	 * @return true if there is a wall just West of this corner
	 */
	public boolean wallOnStreetWestOf(int street, int avenue){
		return wallOnStreetEastOf(street, avenue - 1);
	}
	
	/** Determine if there is a wall North of a given corner
	 * @param street the street of the corner
	 * @param avenue the avenue of the corner
	 * @return true if there is a wall just North of this corner
	 */
	public boolean wallOnAvenueNorthOf(int street, int avenue){
		return eastWestWalls.contains(new Point(street, avenue));
	}
	
	/** Determine if there is a wall just South of a given corner
	 * @param street the street of the corner
	 * @param avenue the avenue of the corner
	 * @return true if there is a wall just South of this corner
	 */
	public boolean wallOnAvenueSouthOf(int street, int avenue){
		return eastWestWalls.contains(new Point(street - 1, avenue));
	}
	
	/** Determine if there is one or more beepers on a given corner
	 * @param street the street of the corner
	 * @param avenue the avenue of the corner
	 * @return true if the corner has any beepers
	 */
	public boolean hasBeeper(int street, int avenue){
		return beepers.containsKey(new Point(street, avenue));
	}

	
}
