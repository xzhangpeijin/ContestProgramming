package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A266
{	
	public void solve() throws IOException 
	{
	  int n = nextInt();
	  int m = nextInt();
	  int a = nextInt();
	  int b = nextInt();
	  if (m * a < b) {
	    b = m * a;
	  }
	  long cost = 0;
	  cost += (n / m) * b;
	  int remain = n % m;
	  int min = Math.min(remain * a, b);
	  cost += min;
	  System.out.println(cost);
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
		new A266().run();
	}
}
