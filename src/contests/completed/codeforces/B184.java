package contests.completed.codeforces;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B184
{	
	public B184()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		BigInteger p = new BigInteger(st.nextToken());
		BigInteger q = new BigInteger(st.nextToken());
		BigInteger bgcd = p.gcd(q);
		p = p.divide(bgcd);
		q = q.divide(bgcd);
		
		int n = Integer.parseInt(in.nextLine());
		
		String[] a = new String[n];
		st = new StringTokenizer(in.nextLine());
		for(int x = 0; x < n; x++)
			a[x] = st.nextToken();
		
		if(n == 1)
		{
			if(p.equals(new BigInteger(a[0])) && q.equals(new BigInteger("1")))
				System.out.println("YES");
			else
				System.out.println("NO");
			return;
		}
		
		BigInteger[] frac = new BigInteger[2];
		frac[0] = new BigInteger("1");
		frac[1] = new BigInteger(a[n - 1]);
		
		for(int x = n - 2; x >= 0; x--)
		{
			frac[0] = frac[0].add(new BigInteger(a[x]).multiply(frac[1]));
			bgcd = frac[0].gcd(frac[1]);
			frac[0] = frac[0].divide(bgcd);
			frac[1] = frac[1].divide(bgcd);
			
			if(x != 0)
			{
				BigInteger temp = frac[0];
				frac[0] = frac[1];
				frac[1] = temp;
			}
		}
		
		if(frac[0].equals(p) && frac[1].equals(q))
			System.out.println("YES");
		else
			System.out.println("NO");
		
		//System.out.println(frac[0] + " " + frac[1] + " " + p + " " + q);
	}
	
	private int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}
	
	public static void main(String[] args)
	{
		new B184();
	}
}
