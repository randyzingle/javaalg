package com.jbergin.robot;


import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;
import static com.jbergin.robot.World.*;

public class RobotTest {
	private World world = null;
	private MiniKarel chuck = null;
	private UrSpecification sue = null;
	
	@Before
	public void setUp() throws Exception {
		world = new World();
		chuck = new MiniKarel("Charles", INFINITE, world);
		sue = new MiniKarel("Susan", 0, world);
	}
	
	public void populateWorld(){
		
	}
	
	@Test
	public void testTurnOff(){
		sue.turnOff();
		try {
			sue.move();
			fail("Should have thrown an exception");
		} catch (RuntimeException e) {
			System.out.println(e);
		}
		try {
			sue.turnLeft();
			fail("Should have thrown an exception");
		} catch (RuntimeException e) {
			System.out.println(e);			
		}
		try {
			world.placeBeeper(0, 0);
			sue.pickBeeper();
			fail("Should have thrown an exception");
		} catch (RuntimeException e) {
			System.out.println(e);			
		}
	}
	
	@Test
	public void testMoves() throws Exception{
		chuck.move();
//		chuck.assertOnStreet(1);
	}
	
	public static void main(String [] args){
		
		JUnitCore runner = new JUnitCore();
		runner.run(RobotTest.class);
	}
}
