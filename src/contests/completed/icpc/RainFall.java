package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class RainFall
{	
	public void solve() throws IOException 
	{
		double L = nextDouble();
		double K = nextDouble();
		double T1 = nextDouble();
		double T2 = nextDouble();
		double H = nextDouble();
		
		if (H < L) {
			double ans = H;
			System.out.println(ans + " " + ans);
		} else {
			ArrayList<Double> possibilities = new ArrayList<Double>(3);
			if (H == L) {
				possibilities.add(H);
			}
			double a = T1;
			double b = -1 * (K * T1 + K * T2 + H);
			double c = K * L;
			double disc = Math.sqrt(b * b - 4 * a * c);
			
			double pos = (-1 * b + disc) / (2 * a);
			if (pos >= K && pos * T1 >= L) {
				possibilities.add(pos * T1);
			}
			
			pos = (-1 * b - disc) / (2 * a);
			if (pos >= K && pos * T1 >= L) {
				possibilities.add(pos * T1);
			}
			
			System.out.println(Collections.min(possibilities) + " " + Collections.max(possibilities));
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
		new RainFall().run();
	}
}
