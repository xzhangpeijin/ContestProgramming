package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A206
{	
	public void solve() throws IOException 
	{
		int k = nextInt();
		int d = nextInt();
		char[] ans = new char[k];
		for(int x = 0; x < k; x++)
			ans[x] = '0';
		if(d > 0 || k == 1)
		{	
			ans[0] = (char)(d + 48);
			System.out.println(new String(ans));
		}
		else
		{
			System.out.println("No solution");
		}
	}

	public int getSol(int dig, String cur)
	{
		if(cur.length() > dig)
			return -1;
		return -1;
	}

	public int dr(int a)
	{
		String val = String.valueOf(a);
		int b = 0;
		for(int x = 0; x < val.length(); x++)
			b += val.charAt(x) - 48;
		if(b < 10)
			return b;
		else
			return dr(b);
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
		new A206().run();
	}
}
