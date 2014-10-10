package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B206
{	
	public void solve() throws IOException 
	{
		int[] c = new int[4];
		for(int x = 0; x < 4; x++)
			c[x] = nextInt();
		int n = nextInt();
		int m = nextInt();
		
		int total = 0;
		int cost = 0;
		for(int x = 0; x < n; x++)
		{
			int a = nextInt();
			if(a * c[0] > c[1])
				cost += c[1];
			else
				cost += a * c[0];
		}
		if(cost > c[2])
			cost = c[2];
		total += cost;
		cost = 0;
		for(int x = 0; x < m; x++)
		{
			int a = nextInt();
			if(a * c[0] > c[1])
				cost += c[1];
			else
				cost += a * c[0];
		}
		if(cost > c[2])
			cost = c[2];
		total += cost;
		if(total > c[3])
			total = c[3];
		System.out.println(total);
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
		new B206().run();
	}
}
