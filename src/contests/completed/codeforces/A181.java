package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class A181
{
	public static void main(String[] args)
	{
		new A181();
	}
	
	public A181()
	{
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		ArrayList<Integer> pos = new ArrayList<Integer>();
		ArrayList<Integer> neg = new ArrayList<Integer>();
		ArrayList<Integer> zero = new ArrayList<Integer>();
		
		for(int x = 0; x < n; x++)
		{
			int next = Integer.parseInt(st.nextToken());
			if(next > 0)
				pos.add(next);
			else if(next < 0)
				neg.add(next);
			else
				zero.add(next);
		}
		
		System.out.println(1 + " " + neg.get(0));
		neg.remove(0);
		
		if(pos.size() > 0)
		{
			System.out.println(1 + " " + pos.get(0));
			pos.remove(0);
		}
		else
		{
			System.out.println(2 + " " + neg.get(0) + " " + neg.get(1));
			neg.remove(0);
			neg.remove(0);
		}
		
		System.out.print(pos.size() + neg.size() + zero.size());
		
		for(int x = 0; x < pos.size(); x++)
			System.out.print(" " + pos.get(x));
		for(int x = 0; x < neg.size(); x++)
			System.out.print(" " + neg.get(x));
		for(int x = 0; x < zero.size(); x++)
			System.out.print(" " + zero.get(x));
	}
	
}
