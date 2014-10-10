package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class C206
{	
	int n, l, r, Ql, Qr;
	int[] w;
	
	public void solve() throws IOException 
	{
		n = nextInt();
		l = nextInt();
		r = nextInt();
		Ql = nextInt();
		Qr = nextInt();
		
		w = new int[n];
		for(int x = 0; x < n; x++)
			w[x] = nextInt();
		
		int ans = Math.min(min(1, n - 1, l * w[0], true), min(0, n - 2, r * w[n - 1], false));
		System.out.println(ans);
	}
	
	public int min(int start, int end, int total, boolean left)
	{
		if(start == end)
		{
			int lcost = w[start] * l;
			int rcost = w[end] * r;
			if(left)
				lcost += Ql;
			else
				rcost += Qr;
			return total + Math.min(lcost, rcost);
		}
		else
		{
			if(left)
			{
				int lcost = total;
				for(int x = start; x <= end; x++)
					lcost += w[x] * l + Ql;
				return Math.min(lcost, min(start, end - 1, total + w[end] * r, false));
			}
			else
			{
				int rcost = total;
				for(int x = 0; x <= end; x++)
					rcost += w[x] * r + Qr;
				return Math.min(rcost, min(start + 1, end, total + w[start] * l, true));
			}
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
		new C206().run();
	}
}
