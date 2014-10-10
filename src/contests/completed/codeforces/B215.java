package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B215
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int m = nextInt();
		int[] arr = new int[n];
		int[] counts = new int[n];
		for(int x = 0; x < n; x++)
			arr[x] = nextInt();
		HashSet<Integer> distinct = new HashSet<Integer>();
		for(int x = 0; x < n; x++)
		{
			distinct.add(arr[n - 1 - x]);
			counts[n - 1 - x] = distinct.size();
		}
		for(int x = 0; x < m; x++)
		{
			int l = nextInt();
			System.out.println(counts[l - 1]);
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
		new B215().run();
	}
}
