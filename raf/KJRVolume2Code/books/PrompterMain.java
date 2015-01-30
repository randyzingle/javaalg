/*
 * Created on Jun 9, 2006
 * 
 * @author jbergin
 *
 */
package books;

import javax.swing.JFrame;

public class PrompterMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Prompter prompt =  new Prompter();
		long aNum = prompt.getLong("How old is it?");
		System.out.println("Age: " + aNum);
		double val = prompt.getDouble("What is its width?");
		System.out.println("Width: " + val);
		System.exit(0);
	}

}
