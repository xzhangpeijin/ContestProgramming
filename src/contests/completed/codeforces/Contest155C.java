package contests.completed.codeforces;
import java.util.*;
import java.io.*;

public class Contest155C
{
	public Contest155C() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		FileWriter f = new FileWriter("output.txt");
		
		String input = in.readLine();
		char[] values = input.toCharArray();
		char[] desired = in.readLine().toCharArray();
		
		int[] occur = new int[26];
		
		for(int x = 0; x < values.length; x++)
			occur[(int)(values[x]) - 65]++;
		for(int x = 0; x < desired.length; x++)
			occur[(int)(desired[x]) - 65]--;
		
		int num = 0;
		
		for(int x = 0; x < occur.length; x++)
		{
			if(occur[x] > 0)
			{
				num+= occur[x];
				char val = (char)(x + 65);
				System.out.println(val);
				int numoccur = numOccur(values, val);
				for(int y = 0; y < values.length; y++)
				{
					System.out.println(numoccur + " " + occur[x]);
					if(numoccur == 0)
						break;
					if(values[y] == val && numoccur == occur[x])
					{
						System.out.println("b");
						values[y] = ' ';
						numoccur--;
						occur[x]--;
					}
					else if(values[y] == val)
					{
						System.out.println("a");
						if(y < values.length - 2 && values[y] > values[y + 1])
						{
							System.out.println("c");
							occur[x]--;
							values[y] = ' ';
						}
						numoccur--;
					}
				}
			}
		}
		System.out.println();
		for(int x = 0; x < values.length; x++)
			System.out.print(values[x]);
		System.out.println();
		String output = "";
		
		int index = 0;
		for(int x = 0; x < occur.length; x++)
		{
			if(occur[x] < 0)
			{
				
				char val = (char)(x + 65);
				System.out.println(val);
				while(index < values.length && values[index] <= val)
				{
					output += values[index];
					index++;
				}
				for(int y = 0; y < Math.abs(occur[x]); y++)
					output += val;
			}
		}
		System.out.println(num + "\n" + output);
		
	}
	
	public int numOccur(char[] a, char b)
	{
		int total = 0;
		for(int x = 0; x < a.length; x++)
			if(a[x] == b)
				total++;
		return total;
	}
	
	public static void main(String[] args) throws Exception
	{
		new Contest155C();
	}
}
