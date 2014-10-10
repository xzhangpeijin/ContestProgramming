package contests.completed.codeforces;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B220
{	
	public void solve() throws IOException 
	{
		String a = nextLine();
		BigInteger result = new BigInteger("1");
		int last = -1;
		long count = 0;
		for(int x = 0; x < a.length() - 1; x++)
		{
			int cur = Integer.valueOf(a.charAt(x)) - 48;
			int next = Integer.valueOf(a.charAt(x + 1)) - 48;
			if(cur + next == 9 && count == 0)
			{
				last = cur;
				count += 2;
			}
			else if(next == last && count > 0)
			{
				count++;
				last = cur;
			}
			else if(count > 0)
			{
				if(count % 2 == 1)
					result = result.multiply(new BigInteger("2"));
				count = 0;
			}
		}
		if(count % 2 == 1)
			result = result.multiply(new BigInteger("2"));
		System.out.println(result);
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
		new B220().run();
	}
}
