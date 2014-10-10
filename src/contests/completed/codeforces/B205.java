package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B205
{	
	public void solve() throws IOException 
	{
		int[] stack1 = new int[100];
		int[] stack2 = new int[100];
		int n = nextInt() * 2;
		int[] ans = new int[n];
		int count1 = 0;
		int count2 = 0;
		int dupcount = 0;

		for(int x = 0; x < n; x++)
		{
			//System.out.println(count1 + " " + count2);
			int a = nextInt();
			if(stack1[a - 1] != 0 && stack2[a - 1] != 0)
			{
				ans[x] = -1;
			}
			else if(count1 <= count2)
			{
				if(stack1[a - 1] == 0)
				{
					stack1[a - 1]++;
					count1++;
					ans[x] = 1;
				}
				else
				{
					stack2[a - 1]++;
					count2++;
					ans[x] = 2;
				}
			}
			else
			{
				if(stack2[a - 1] == 0)
				{
					stack2[a - 1]++;
					count2++;
					ans[x] = 2;
				}
				else
				{
					stack1[a - 1]++;
					count1++;
					ans[x] = 1;
				}
			}
		}
		System.out.println(count1 * count2);
		for(int x = 0; x < n; x++)
		{
			if(ans[x] == -1)
			{
				if(count1 <= count2)
				{
					count1++;
					ans[x] = 1;
				}
				else
				{
					count2++;
					ans[x] = 2;
				}
			}
		}
		for(int x = 0; x < n; x++)
			System.out.print(ans[x] + " ");
	}

	public BufferedReader br;
	public StringTokenizer st;
	public PrintWriter out;

	public String nextToken() throws IOException {
		while(st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}

		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws  IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public void run() throws IOException 
	{	
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		oj = true;
		br = new BufferedReader( new InputStreamReader( oj ? System.in : new FileInputStream("input.txt")));
		out = new PrintWriter( oj ? System.out : new FileOutputStream("output.txt"));
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException 
	{
		new B205().run();
	}
}
