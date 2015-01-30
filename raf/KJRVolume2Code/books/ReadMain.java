/*
 * Created on Jun 9, 2006
 * 
 * @author jbergin
 *
 */
package books;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadMain
{

	public static void main(String[] args)
	{
		try
		{	BufferedReader inFile = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Name of the input file: ");
			String filename = inFile.readLine();
			File theFile = new File(filename);
			if(!theFile.exists())
			{
				System.out.println("There is no file named: " + filename);
				System.out.println("Exiting.");
				System.exit(1);
			}
			BufferedReader bookFile = new BufferedReader(new FileReader(theFile));
			String sentinel = "";
			while(sentinel != null && sentinel.equals("")) 
			{
				String title = bookFile.readLine();
				if(title == null)
				{
					break;
				}
				String author = bookFile.readLine();
				Book aBook = new Book (title,author);
				sentinel = bookFile.readLine();
				System.out.println("Book: " +title + " by: " + author);
			}		
		}
		catch(IOException ioe)
		{
			System.out.println("File Error. Can't proceed. " + ioe);
		}
	}
}
