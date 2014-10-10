package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A184
{	
	public A184()
	{
		Scanner in = new Scanner(System.in);
		
		int k = Integer.parseInt(in.nextLine());
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int places[] = new int[3];
		int count = 0;
		String[] d = new String[k];
		for(int x = 0; x < k; x++)
		{	
			d[x] = st.nextToken();
			if(d[x].equals("0") && places[0] != 1)
			{
				count++;
				places[0] = 1;
			}
			if(d[x].length() == 2 && d[x].charAt(1) == '0' && places[1] != 1)
			{
				count++;
				places[1] = 1;
			}
			if(d[x].equals("100") && places[2] != 1)
			{
				count++;
				places[2] = 1;
			}
		}
		
		ArrayList<String> ans = new ArrayList<String>();
		if(places[0] == 1)
		{
			ans.add("0");
		}
		if(places[2] == 1)
		{
			ans.add("100");
		}
		if(places[1] == 1)
		{
			boolean one = false;
			boolean two = false;
			for(int x = 0; x < k; x++)
			{
				if(d[x].length() == 2 && d[x].charAt(1) == '0' && !one)
				{
					ans.add(d[x]);
					one = true;
				}
				if(d[x].length() == 1 && !d[x].equals("0") && !two)
				{
					ans.add(d[x]);
					two = true;
				}
			}
		}
		else
		{
			for(int x = 0; x < k; x++)
			{
				if(!d[x].equals("100") && !d[x].equals("0"))
				{
					ans.add(d[x]);
					break;
				}
			}
		}
		System.out.println(ans.size());
		for(int x = 0; x < ans.size(); x++)
			System.out.print(ans.get(x) + " ");
	}
	
	public static void main(String[] args)
	{
		new A184();
	}
}
