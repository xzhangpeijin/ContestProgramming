package contests.completed.codeforces;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class D183
{	
	public D183()
	{
		Scanner in = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int[] result = new int[4];
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int xco = Integer.parseInt(st.nextToken());
		int yco = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = new BigInteger(String.valueOf(a)).gcd(new BigInteger(String.valueOf(b))).intValue();
		
		a /= gcd;
		b /= gcd;
		
		int length = a, width = b;
		
		while(length <= n && width <= m)
		{
			length += a;
			width += b;
		}
		length -= a;
		width -= b;
		
		//System.out.println(length + " " + width);
		
		if(length % 2 == 0)
			result[0] = xco - length / 2;
		else
			result[0] = xco - length / 2 - 1;
		
		if(result[0] < 0)
			result[0] = 0;
		if(result[0] > n - length)
			result[0] = n - length;
		
		result[2] = result[0] + length;
		
		if(width % 2 == 0)
			result[1] = yco - width / 2;
		else
			result[1] = yco - width / 2 - 1;
		
		if(result[1] < 0)
			result[1] = 0;
		if(result[1] > m - width)
			result[1] = m - width;
		result[3] = result[1] + width;
			
		System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
	}
	
	public static void main(String[] args)
	{
		new D183();
	}
}
