/*
 * Created on Aug 29, 2004
 * 
 * @author jbergin
 *
 */
package com.jbergin.calculator;

import junit.framework.TestCase;

/**
 * @author jbergin
 *
 */
public class CalculatorTest extends TestCase
{
	CalculatorModel calculator;
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception
	{
		calculator = new CalculatorModel();
	}
	
	public void testDisplay()
	{
		assertEquals("initial display failure", 0, calculator.getDisplay());
	}
	
	public void testPress()
	{
		calculator.pressFive();
		assertEquals("single press error", 5, calculator.getDisplay());
	}
	
	public void testAccumulate()
	{
		calculator.pressFive();
		calculator.pressFive();
		calculator.pressThree();
		assertEquals("multiple press error", 553, calculator.getDisplay());
	}
	
	public void testPlusClear()
	{
		calculator.pressFive();
		calculator.pressFive();
		calculator.pressThree();
		assertEquals("multiple press error", 553, calculator.getDisplay());
		calculator.pressPlus();
		assertEquals("first plus error", 553, calculator.getDisplay());
		calculator.pressThree();
		assertEquals("num after plus error", 3, calculator.getDisplay());
		calculator.pressThree();
		assertEquals("numbers after press error", 33, calculator.getDisplay());
		calculator.pressPlus();
		assertEquals("second plus error", 586, calculator.getDisplay());

	}
	
	public void testEquals()
	{
		calculator.pressFive();
		calculator.pressFive();
		calculator.pressThree();
		calculator.pressPlus();
		calculator.pressThree();
		calculator.pressThree();
		calculator.pressEquals();
		assertEquals("equals error", 586, calculator.getDisplay());
		calculator.pressFive();
		calculator.pressThree();
		calculator.pressPlus();
		calculator.pressThree();
		calculator.pressEquals();
		assertEquals("second calc error", 56, calculator.getDisplay());
	}
	
	public void testContinued()
	{
		calculator.pressFive();
		calculator.pressFive();
		calculator.pressThree();
		calculator.pressPlus();
		calculator.pressThree();
		calculator.pressThree();
		calculator.pressEquals();
		assertEquals("equals error", 586, calculator.getDisplay());
		calculator.pressPlus();
		calculator.pressFive();
		calculator.pressEquals();
		assertEquals("second calc error", 591, calculator.getDisplay());
		
	}

}
