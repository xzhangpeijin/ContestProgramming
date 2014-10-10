package contests.completed.codeforces;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C184
{	
	public C184()
	{
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		int[] a = new int[n];
		for(int x = 0; x < n; x++)
			a[x] = Integer.parseInt(st.nextToken());

		boolean change;
		do
		{
			change = false;
			for(int x = 0; x < n - 1; x++)
			{
				if(a[x] == a[x + 1] && a[x] != -1)
				{
					change = true;
					a[x] = -1;
					a[x + 1]++;
				}
			}
			Arrays.sort(a);
		}while(change);
		
		int target = a[n - 1] + 1;
		for(int x = 0; x < n; x++)
			if(a[x] != -1)
				target--;
		
		System.out.println(target);
	}
	
	public static void main(String[] args)
	{
		new C184();
	}
}
