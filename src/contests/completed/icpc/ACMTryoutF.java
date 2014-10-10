package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMTryoutF
{	
	public void solve() throws IOException 
	{
		int cases = nextInt();
		for(int q = 0; q < cases; q++)
		{
			int a2 = nextInt();
			int n = nextInt();
			int mod = nextInt();
			double vol = 1 + Math.pow(a2, 2);
			vol %= mod;
		}
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
		new ACMTryoutF().run();
	}
}
