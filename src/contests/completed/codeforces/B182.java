package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class B182
{
	public static void main(String[] args)
	{
		new B182();
	}
	
	public B182()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] times = new int[n];
		
		int index = 0;
		for(int x = 0; x < n; x++)
		{
			st = new StringTokenizer(in.nextLine());
			
			int length = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
			times[x] = length;
		}
		
		int selected = 0;
		st = new StringTokenizer(in.nextLine());
		int target = Integer.parseInt(st.nextToken());
		int time = 0;
		for(int x = 0; x < n; x++)
		{
			time += times[x];
			while(target <= time)
			{
				System.out.println(x + 1);
				selected++;
				if(selected < m)
					target = Integer.parseInt(st.nextToken());
				else
					target = 1000000001;
			}
		}
		
	}
	
}
