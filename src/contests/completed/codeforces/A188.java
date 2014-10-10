package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A188
{	
	public A188()
	{
		Scanner in = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		if((n % 2 == 1 && k > n/2 + 1) || (n % 2 == 0 && k > n/2))
		{
			System.out.println(2 * (k - n + n / 2));
		}
		else
		{
			System.out.println(2 * k - 1);
		}
	}
	
	public static void main(String[] args)
	{
		new A188();
	}
}
