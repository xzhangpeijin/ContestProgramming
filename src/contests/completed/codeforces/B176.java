package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class B176
{
	public static void main(String[] args)
	{
		new B176();
	}
	
	public B176()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st;
		Book[] books = new Book[Integer.parseInt(in.nextLine())];
		
		int thickness = 0;
		
		for(int x = 0; x < books.length; x++)
		{
			st = new StringTokenizer(in.nextLine());
			books[x] = new Book(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			thickness += books[x].thickness;
		}
		
		Arrays.sort(books);
		
		int width = 0;

//		for(int x = 0; x < books.length; x++)
//		{
//			System.out.println(books[x].width + " " + books[x].thickness);
//		}

		for(int x = 0; x < books.length; x++)
		{
			if(thickness - width - books[x].thickness >= books[x].width)
			{
				width += books[x].width;
				thickness -= books[x].thickness;
			}
		}
		
		System.out.println(thickness);
	}
	
	public class Book implements Comparable<Book>
	{
		public int thickness;
		public int width;
		
		public Book(int thickness, int width)
		{
			this.thickness = thickness;
			this.width = width;
		}
		
		public int compareTo(Book a)
		{
			if(thickness == a.thickness)
				return width - a.width;
			else if(a.thickness > thickness)
				return 2 * width - a.width;
			else
				return width - 2 * a.width;
		}
	}
	
}
