package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class E218
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int[] loc = new int[n];
		ArrayList<Weight> weights = new ArrayList<Weight>();
		for(int x = 0; x < n; x++)
		{
			loc[x] = nextInt();
			weights.add(new Weight(x));
		}
		int k = nextInt();
		
		for(int x = 0; x < n; x++)
			for(int y = 0; y < n; y++)
				weights.get(x).add(Math.abs(loc[x] - loc[y]));
		
		for(int x = 0; x < n - k; x++)
		{
			Collections.sort(weights);
			int city = weights.get(0).name;
			for(int y = 0; y < weights.size(); y++)
			{
				int othercity = weights.get(y).name;
				weights.get(y).sub(Math.abs(loc[city] - loc[othercity]));
			}
			weights.remove(0);
		}
		for(int x = 0; x < k; x++)
		{
			System.out.print(weights.get(x).name + 1);
			if(x != k - 1)
				System.out.print(" ");
		}
		System.out.println();
	}
	
	public class Weight implements Comparable<Weight>
	{
		public int name;
		public int weight = 0;
		
		public Weight(int name)
		{
			this.name = name;
		}
		
		public void add(int a)
		{
			weight += a;
		}
		
		public void sub(int a)
		{
			weight -= a;
		}
		
		public int compareTo(Weight a)
		{
			return a.weight - weight;
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
		new E218().run();
	}
}
