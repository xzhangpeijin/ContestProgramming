package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMBCasting
{	
	public void solve() throws IOException 
	{
		int cases = nextInt();
		for(int n = 0; n < cases; n++)
		{
			int num = nextInt();
			int base = nextInt() - 1;
			int total = 0;
			String input = nextToken();
			for(int x = 0; x < input.length(); x++)
				total = (total + input.charAt(x) - 48) % base;
			System.out.println(num + " " + total);
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
		new ACMBCasting().run();
	}
}
