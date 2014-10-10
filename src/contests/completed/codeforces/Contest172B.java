package contests.completed.codeforces;
import java.io.*;
import java.util.*;

public class Contest172B
{
	public static void main(String[] args)
	{
		new Contest172B();
	}
	
	public Contest172B()
	{
		Scanner in = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(in.nextLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		if(n < b)
		{
			double target = (double) a / (double) b;
			double smallestdiff = Double.MAX_VALUE;
			String ans = "";
			for(int x = 1; x <= n; x++)
			{
				double temp = x * target;
//				System.out.println(temp);
				if(temp == (int) temp)
				{
			
					ans = temp + "/" + x;
					break;
				}
				else
				{
					int m;
					if(temp - (int) temp > 0.5)
						m = (int) temp + 1;
					else
						m = (int) temp;
					double newval = Math.abs(target - (double) m / (double) x);
					if(newval < smallestdiff)
					{
						smallestdiff = newval;
						ans = m + "/" + x;
					}
				}
			}
			System.out.println(ans);
		}
		else
			System.out.println(a + "/" + b);
	}
	
	

}
