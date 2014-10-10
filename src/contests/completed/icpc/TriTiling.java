package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class TriTiling
{	
	public void solve() throws IOException 
	{
	  long[] ans = {1,0,3,0,11,0,41,0,153,0,571,0,2131,
	      0,7953,0,29681,0,110771,0,413403,0,1542841,0,
	      5757961,0,21489003,0,80198051,0,299303201};
	  int n;
	  while ((n = nextInt()) != -1) {
	    System.out.println(ans[n]);
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
		new TriTiling().run();
	}
}
