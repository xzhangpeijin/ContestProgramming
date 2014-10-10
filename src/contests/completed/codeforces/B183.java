package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B183
{	
	public B183()
	{
		Scanner in = new Scanner(System.in);
		
		int[] start = new int[3];
		int[] end = new int[3];
		
		String[] temp = in.nextLine().split(":");
		
		start[0] = Integer.parseInt(temp[0]);
		start[1] = Integer.parseInt(temp[1]);
		start[2] = Integer.parseInt(temp[2]);
		
		temp = in.nextLine().split(":");
		
		end[0] = Integer.parseInt(temp[0]);
		end[1] = Integer.parseInt(temp[1]);
		end[2] = Integer.parseInt(temp[2]);
		
		if(start[0] > end[0] || (start[0] == end[0] && start[1] > end[1]) || (start[0] == end[0] && start[1] == end[1] && start[2] > end[2]))
		{
			int[] tempar = start.clone();
			start = end.clone();
			end = tempar;
		}
		
		int total = 0;
		
		for(int x = start[0] + 1; x < end[0]; x++)
		{
			if(isLeap(x))
				total += 366;
			else
				total += 365;
		}
		
		boolean leap = isLeap(start[0]);
		for(int x = start[1] + 1; x <= 12; x++)
			total += days(x, leap);
		total += days(start[1], leap) - start[2] + 1;
		
		leap = isLeap(end[0]);
		for(int x = 1; x < end[1]; x++)
			total += days(x, leap);
		total += end[2];
		
		System.out.println(total - 1);
	}
	
	public int days(int month, boolean leap)
	{
		switch(month)
		{
			case 1: return 31; 
			case 2: return (leap) ? 29 : 28; 
			case 3: return 31; 
			case 4: return 30; 
			case 5: return 31; 
			case 6: return 30; 
			case 7: return 31; 
			case 8: return 31; 
			case 9: return 30; 
			case 10: return 31; 
			case 11: return 30; 
			default: return 31;
		}
	}
	
	public boolean isLeap(int year)
	{
		if(year % 400 == 0)
			return true;
		if(year % 100 == 0)
			return false;
		if(year % 4 == 0)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		new B183();
	}
}
