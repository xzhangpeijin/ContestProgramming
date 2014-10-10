package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class Flooring
{	
	public void solve() throws IOException 
	{
		long[] data = {1, 4, 12, 24, 36, 60, 192, 120, 180, 240, 576, 360, 1296, 900, 720, 840, 9216, 1260, 786432, 1680, 2880, 15360, 3600, 2520, 6480, 61440, 6300, 6720, 2359296, 5040, 3221225472L, 7560, 46080, 983040, 25920, 10080, 206158430208L, 32400, 184320, 15120, 44100, 20160, 5308416, 107520, 25200, 2985984, 9663676416L, 27720, 233280, 45360, 2949120, 430080, 129600, 50400, 414720, 60480, 11796480, 339738624, 921600, 55440, 60466176, 16106127360L, 100800, 83160, 1658880, 322560, 191102976, 176400, 188743680, 181440, 633318697598976L, 110880, 21743271936L, 1166400, 226800};
		while(true)
		{
			int n = nextInt();
			if(n == 0)
				break;
			System.out.println(data[n - 1]);
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
		new Flooring().run();
	}
}
