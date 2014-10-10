package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest156B
{
	public static void main(String[] args)
	{
		new Contest156B();
	}
	
	public Contest156B()
	{
		Scanner in = new Scanner(System.in);
		
		char[] input = in.nextLine().toCharArray();
		
		int[] count = new int[2];
		
		for(int x = 0; x < input.length; x++)
			if(input[x] == 'x')
				count[0]++;
			else
				count[1]++;
		
		char out;
		
		if(count[0] > count[1])
			out = 'x';
		else
			out = 'y';
		
		for(int x = 0; x < Math.abs(count[0] - count[1]); x++)
			System.out.print(out);
	}
}
