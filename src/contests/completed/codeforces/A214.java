package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A214
{	
	public void solve() throws IOException 
	{
		int cost = nextInt();

		for(int x = 0; x < 4; x++)
		{
			int a = nextInt();
			int b = nextInt();
			int c = nextInt();
			int d = nextInt();
			if(Math.min(a, b) + Math.min(c, d) <= cost)
			{
				System.out.println(x + 1 + " " + Math.min(a, b) + " " + (cost - Math.min(a,  b)));
				return;
			}
		}
		
		System.out.println("-1");
		return;
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
		new A214().run();
	}
}
