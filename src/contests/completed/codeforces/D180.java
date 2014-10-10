package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class D180
{
	public static void main(String[] args)
	{
		new D180();
	}
	
	public D180()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] counts = new int[k];
		
		st = new StringTokenizer(in.nextLine());
		for(int x = 0; x < n; x++)
		{
			counts[Integer.parseInt(st.nextToken()) - 1]++;
		}
		
		st = new StringTokenizer(in.nextLine());
		for(int x = 0; x < m; x++)
		{
			counts[Integer.parseInt(st.nextToken()) - 1]--;
		}
		
		String possible = "NO";

		int total = 0;
		for(int x = counts.length - 1; x >= 0; x--)
		{
			if(counts[x] != 0)
			{
				total += counts[x];
				if(total > 0)
				{
					possible = "YES";
					break;
				}
			}
		}
		
		System.out.println(possible);
	}
	
}
