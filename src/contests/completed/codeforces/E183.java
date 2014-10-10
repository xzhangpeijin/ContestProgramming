package contests.completed.codeforces;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class E183
{	
	public E183()
	{
		long time = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] a = new int[n];
		st = new StringTokenizer(in.nextLine());
		
		for(int x = 0; x < n; x++)
			a[x] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		
		for(int x = n - k; x <= a[n - 1] + 1; x++)
		{
			if(isValid(a, x, k))
			{
				System.out.println(x);
				break;
			}
		}
		System.out.println(System.currentTimeMillis() - time);
	}
	
	public boolean isValid(int[] a, int mod, int k)
	{
		int[] data = new int[mod];
		
		int over = 0;
		for(int x = 0; x < a.length; x++)
		{
			int index = a[x] % mod;
			data[index]++;
			if(data[index] > 1)
			{
				over++;
				if(over > k)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		new E183();
	}
}
