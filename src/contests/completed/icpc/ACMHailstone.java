package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMHailstone
{	
	public void solve() throws IOException 
	{
		int cases = nextInt();
		for(int n = 0; n < cases; n++)
		{
			int num = nextInt();
			int start = nextInt();
			int largest = start;
			while(start > 1)
			{
				//System.out.println(start);
				if(start % 2 == 0)
					start /= 2;
				else
					start = start * 3 + 1;
				largest = Math.max(start, largest);
			}
			System.out.println(num + " " + largest);
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
		new ACMHailstone().run();
	}
}
