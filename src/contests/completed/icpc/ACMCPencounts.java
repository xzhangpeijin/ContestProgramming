package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMCPencounts
{	
	public void solve() throws IOException 
	{
		int cases = nextInt();
		for(int n = 0; n < cases; n++)
		{
			int num = nextInt();
			int length = nextInt();
			int total = 0;
			for(int a = 1; a <= length / 2; a++)
			{
				for(int b = a; b <= length - a - b; b++)
				{
					int c = length - a - b;
					if(a + b > c && b + c > a && a + c > b)
					{
						if(a != b && a != c && b != c)
							total++;
						total++;
					}
				}
			}
			System.out.println(num + " "+ total);
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
		new ACMCPencounts().run();
	}
}
