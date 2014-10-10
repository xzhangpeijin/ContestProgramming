package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest172A
{
	public static void main(String[] args)
	{
		new Contest172A();
	}
	
	public Contest172A()
	{
		Scanner in = new Scanner(System.in);
		
		String word = in.nextLine();
		
		word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
		
		System.out.println(word);
	}
	

}
