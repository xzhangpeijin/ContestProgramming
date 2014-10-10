package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B266
{	
	public void solve() throws IOException 
	{
		long n = nextLong();
		long a = nextLong();
		long b = nextLong();
		
		long required = 6L * n;
		
		if (required < a * b) {
			System.out.println(a * b);
			System.out.println(a + " " + b);
			return;
		}

		long min = Long.MAX_VALUE;
		long mina = -1, minb = -1;
		
		boolean swap = false;
		if (a > b) {
			long temp = a; 
			a = b;
			b = temp;
			swap = true;
		}
		
		for (long x = a; x < 1000000; x++) {
			long newb = required / x + ((required % x == 0) ? 0 : 1);
			if (newb < b) {
				break;
			}
			long total = newb * x;
			if (total < min) {
					min = total;
					mina = x;
					minb = newb;
			}
			if (min == required) {
				break;
			}
		}
		
		System.out.println(min);
		if (!swap) 
			System.out.println(mina + " " + minb);
		else 
			System.out.println(minb + " " + mina);
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
		new B266().run();
	}
}
