package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class C198
{	
	public int[] values = new int[2000];
	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int count = 0;
		for(int x = 0; x < n; x++)
			if(nextInt() == -1)
				count++;
		out.println(derange(count));
	}
	
	public int derange(int n)
	{
		if(values[n] != 0)
			return values[n];
		if(n == 1)
			return values[1] = 0;
		if(n == 2)
			return values[2] = 1;
		return values[n] = (n - 1) * (derange(n - 1) + derange(n - 2)) % 1000000007;
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
		new C198().run();
	}
}
