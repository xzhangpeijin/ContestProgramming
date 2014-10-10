package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest156A
{
	public static void main(String[] args)
	{
		new Contest156A();
	}
	
	public Contest156A()
	{
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		int[] totals = new int[3];
		for(int x = 0; x < num; x++)
		{
			totals[x % 3] += in.nextInt();
		}
		
		int max = 0;
		String muscle;
		max = Math.max(max, totals[0]);
		max = Math.max(max, totals[1]);
		max = Math.max(max, totals[2]);
		
		if(max == totals[0])
			muscle = "chest";
		else if(max == totals[1])
			muscle = "biceps";
		else
			muscle = "back";
		
		System.out.println(muscle);
	}
}
