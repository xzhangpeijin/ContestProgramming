package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.*;

public class Contest145A
{
	public Contest145A() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		int length = Integer.valueOf(in.readLine());
		String input = in.readLine();
		
		for(int x = 0; x < length / 2; x++)
		{
			int a = x;
			int b = length / 2 + x;
			if(input.charAt(a) == 'R' && input.charAt(b) == 'L')
				f.write((int)(b + 1) + " " + (int)(a + 1) + "\n");
			else
				f.write((int)(a + 1) + " " + (int)(b + 1) + "\n");
		}
		f.flush();
		f.close();
	}
	
	public static void main(String[] args) throws Exception
	{
		new Contest145A();
	}
}
