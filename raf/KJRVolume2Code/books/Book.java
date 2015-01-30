/*
 * Created on Jun 9, 2006
 * 
 * @author jbergin
 *
 */
package books;

public class Book
{
	public Book(String title, String author)
	{
		this.title = title;
		this.author = author;
	}
	
	public String title()
	{
		return  title;
	}
	
	public String author()
	{
		return  author;
	}
	
	private String title;
	private String author;
}
