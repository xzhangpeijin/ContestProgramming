package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class B181
{
	public static void main(String[] args)
	{
		new B181();
	}
	
	public B181()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> groups = new ArrayList<int[]>();
		ArrayList<Integer> placed = new ArrayList<Integer>();
		int[] locations = new int[n];
		
		for(int x = 0; x < m; x++)
		{
			st = new StringTokenizer(in.nextLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(!placed.contains(a) && !placed.contains(b))
			{
				int[] group = new int[3];
				group[0] = a;
				group[1] = b;
				groups.add(group);
				placed.add(a);
				placed.add(b);
				locations[a - 1] = groups.size() - 1;
				locations[b - 1] = groups.size() - 1;
			}
			else if(placed.contains(a) && !placed.contains(b))
			{
				int loc = locations[a - 1];
				if(groups.get(loc)[2] != 0)
				{
					System.out.println(-1);
					return;
				}
				groups.get(loc)[2] = b;
				placed.add(b);
				locations[b - 1] = loc;
			}
			else if(!placed.contains(a) && placed.contains(b))
			{
				int loc = locations[b - 1];
				if(groups.get(loc)[2] != 0)
				{
					System.out.println(-1);
					return;
				}
				groups.get(loc)[2] = a;
				placed.add(a);
				locations[a - 1] = loc;
			}
			else if(placed.contains(a) && placed.contains(b) && locations[a - 1] != locations[b - 1])
			{
				System.out.println(-1);
				break;
			}	
		}
		
		int newgroups = n / 3 - groups.size();
		Stack<Integer> remain = new Stack<Integer>();
		
		for(int x = 1; x <= n; x++)
			if(!placed.contains(x))
				remain.push(x);
		
		for(int x = 0; x < newgroups; x++)
			System.out.println(remain.pop() + " " + remain.pop() + " " + remain.pop());
		
		for(int x = 0; x < groups.size(); x++)
		{
			System.out.print(groups.get(x)[0] + " " + groups.get(x)[1]);
			if(groups.get(x)[2] == 0)
				System.out.println(" " + remain.pop());
			else
				System.out.println(" " + groups.get(x)[2]);
		}
	}
	
}
