package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACM7
{	
	public void solve() throws IOException 
	{
		boolean start = true;
		while(start)
		{
			int n = nextInt();
			if(n == 0)
			{
				start = false;
				break;
			}
			
			int max = -101;
			int total = 0;
			for(int x = 0; x < n; x++)
			{
				total += nextInt();
				if(total > max)
					max = total;
				if(total < 0)
					total = 0;
			}
			System.out.println(max);
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
		new ACM7().run();
	}
}
