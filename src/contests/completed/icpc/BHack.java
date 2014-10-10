package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class BHack
{	
	public boolean check(long s, long a, long b) {
		boolean f = false;
		if (a * b >= s) {
			f = true;
			System.out.println(a * b + "\n" + a + " " + b);
			return f;
		}
		if (a < b) {
			long temp = a;
			a = b;
			b = temp;
		}
		for (long i = 1; i <= Math.sqrt(s); i++) {
			if ((s % i == 0) && (i >= a && s / i >= b)) {
				System.out.println(s + "\n" + i + " " + s/i);
				return true;
			}
		}
		return false;
	}
	
	public void solve() throws IOException 
	{
		long n = nextLong();
		long a = nextLong();
		long b = nextLong();
		
		long s = 6 * n;
		if (a * b >= s) {
			check(s, a, b);
		} else {
			while (!check(s, a, b)) {
				s++;
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
		new BHack().run();
	}
}
