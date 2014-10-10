package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMARobots
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		char[][] arr = new char[n][n];
		int[][] ans = new int[n][n];
		for(int x = 0; x < n; x++)
			for(int y = 0; y < n; y++)
				ans[x][y] = (arr[x][y] == '#') ? 0 : -1;
		fill(ans, n - 1, n - 1);
	}
	
	public void fill(int[][] arr, int xloc, int yloc)
	{
		
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
		new ACMARobots().run();
	}
}
