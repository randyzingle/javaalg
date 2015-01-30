/*
 * Created on Aug 29, 2004
 * 
 * @author jbergin
 *
 */
package com.jbergin.calculator;

/**
 * @author jbergin
 *
 */
public class CalculatorModel
{
	public class EqualsKey implements CalculatorKey
	{
		public void press()
		{
			lastOperation.operate();
			savedValue = 0;
			currentNumberStrategy = new ClearStrategy(); //new AccumulateStrategy();
			lastOperation = new NullKey();
		}

	}
	
	public class NullKey implements OperatorKey
	{
		public void operate()
		{
			// nothing
		}

		public void press()
		{
			// nothing
		}

	}

	public class ClearStrategy implements NumberStrategy
	{

		public void execute(int value)
		{
			display = value;
			currentNumberStrategy = new AccumulateStrategy();
		}

	}

	public class AccumulateStrategy implements NumberStrategy
	{
		public void execute(int value)
		{
			display = 10*display + value;
		}
	}

	public interface NumberStrategy
	{
		public void execute(int value);
	}

	public class PlusKey implements OperatorKey
	{
		public void operate()
		{
			display = display + savedValue;
		}

		public void press()
		{
			lastOperation.operate();
			savedValue = display;
			lastOperation = this;
			currentNumberStrategy = new ClearStrategy();
		}

	}

	public interface OperatorKey extends CalculatorKey
	{
		public void operate();
	}

	public class NumberKey implements CalculatorKey
	{
		public NumberKey(int value)
		{
			this.value = value;
		}
		
		public void press()
		{
			currentNumberStrategy.execute(value);
		}
		
		private final int value;
	}

	public interface CalculatorKey
	{
		public void press();
	}
	
	public int getDisplay()
	{
		return display;
	}
    
    public void pressFive()
    {
        five.press();
    }
    
    public void pressThree()
    {
        three.press();
    }
    
    public void pressPlus()
    {
        plus.press();
    }
    
    public void pressEquals()
    {
        equals.press();
    }
	
	private int display = 0;
	private int savedValue = 0;
	private OperatorKey lastOperation = new NullKey();
	private NumberStrategy currentNumberStrategy = new AccumulateStrategy();
	
    private final CalculatorKey five = new NumberKey(5);
    private final CalculatorKey three = new NumberKey(3);
    private final CalculatorKey plus = new PlusKey();
    private final CalculatorKey equals = new EqualsKey();
	
}
