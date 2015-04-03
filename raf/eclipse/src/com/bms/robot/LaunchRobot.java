package com.bms.robot;

/**
 * Modify this to manipulate the World.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LaunchRobot {
	static kareltherobot.WorldBuilder builder = null;
	public static void main(String[] args) {
		initializeWorld();
	}
	
    public static void initializeWorld()
    {
        kareltherobot.World.setSize(8,8);
        kareltherobot.World.setDelay(50);
        kareltherobot.World.readWorld("world/world.kwld");
        kareltherobot.World.showSpeedControl(false);
        builder = new kareltherobot.WorldBuilder(true);
        kareltherobot.World.setVisible(true);
    }
    
}
