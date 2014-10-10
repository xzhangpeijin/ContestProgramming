package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class FredLotto
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		while (n != 0) {
			boolean[] hit = new boolean[49];
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < 6; y++) {
					hit[nextInt() - 1] = true;
				}
			}
			boolean hitall = true;
			for (int x = 0; x < 49; x++) {
				hitall &= hit[x];
			}
			if (hitall) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			n = nextInt();
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
		new FredLotto().run();
	}
}
