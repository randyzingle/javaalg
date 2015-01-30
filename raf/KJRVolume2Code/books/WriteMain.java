/*
 * Created on Jun 9, 2006
 * 
 * @author jbergin
 *
 */
package books;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteMain
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader inFile = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Name of the output file: ");
			String filename = inFile.readLine();
			BufferedWriter outFile = new BufferedWriter(new FileWriter(filename));
			
			System.out.println("Input books. Answer no to end.");
			String response = "";
			System.out.print("More? [YES/no]");
			response = inFile.readLine();
			while(!response.equalsIgnoreCase("no"))
			{
				System.out.print("Title:  ");
				String bookTitle = inFile.readLine();
				System.out.print("Author: ");
				String bookAuthor = inFile.readLine();
				Book book = new Book(bookTitle, bookAuthor);
				
				outFile.write(book.title());
				outFile.newLine();
				outFile.write(book.author());
				outFile.newLine();
				outFile.newLine();
				System.out.print("More? [YES/no] ");
				response = inFile.readLine();				
			}
			outFile.close();
		}
		catch (IOException ioe)
		{
			System.out.println("File error, cannot proceed.");
		}
	}
}
