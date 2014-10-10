package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B216
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int k = n - nextInt();
		int l = nextInt();
		int r = nextInt();
		int tot = nextInt();
		int s = nextInt();
		int[] scores = new int[n];
		int total = 0;
		for(int x = n - 1; x >= 0; x--)
		{
			if(x > k)
				scores[x] = r;
			else if(x == k)
				scores[x] = s - total;
			else
				scores[x] = l;
			total += scores[x];
		}
		
		int index = k - 1;
		while(total < tot)
		{
			scores[index]++;
			index--;
			total++;
			if(index < 0)
				index = k - 1;
		}
		if((k != 0 && scores[k] < scores[k - 1]) || scores[k] < l)
		{
			index = k + 1;
			while((k != 0 && scores[k] < scores[k - 1]) || scores[k] < l)
			{
				scores[index]--;
				scores[k]++;
				index++;
				if(index == n)
					index = k + 1;
			}
		}
		
		for(int x = 0; x < n; x++)
		{
			System.out.print(scores[x]);
			if(x != n - 1)
				System.out.print(" ");
		}
		System.out.println();
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
	
	public String nextLine() throws IOException {
		return br.readLine();
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
		new B216().run();
	}
}
