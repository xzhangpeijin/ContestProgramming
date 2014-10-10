package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class A180
{
	public static void main(String[] args)
	{
		new A180();
	}
	
	public A180()
	{
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		String blocks = in.nextLine();
		
		int s, t;
		
		if(!blocks.contains("R"))
		{
			s = blocks.indexOf("L") + 1;
			t = blocks.indexOf("L");
		}
		else if(!blocks.contains("L"))
		{
			s = blocks.indexOf("R") + 1;
			t = blocks.lastIndexOf("R") + 2;
		}
		else
		{
			s = blocks.indexOf("R") + 1;
			t = blocks.indexOf("L");
		}
		
		System.out.println(s + " " + t);
	}
	
}
