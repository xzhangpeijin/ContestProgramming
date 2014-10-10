package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class D214
{
	public int loyalty = -1;
	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int m = nextInt();
		
		Edge[][] adjmat = new Edge[n][n];
		for(int x = 0; x < m; x++)
		{
			int from = nextInt() - 1;
			int to = nextInt() - 1;
			Edge temp = new Edge(nextInt(), nextInt());
			adjmat[from][to] = temp;
			adjmat[to][from] = temp;
		}
		State init = new State(0, -1, Integer.MAX_VALUE);
		ArrayList<State> bfs = new ArrayList<State>();
		bfs.add(init);
		while(!bfs.isEmpty())
		{
			State cur = bfs.remove(0);
			Edge[] list = adjmat[cur.node];
			for(int x = 0; x < list.length; x++)
			{
				if(list[x] != null)
				{
					Edge temp = list[x];
					int lower = Math.max(cur.lower, temp.lower);
					int upper = Math.min(cur.upper, temp.upper);
					if(x == n - 1 && upper - lower > loyalty)
					{
						loyalty = Math.max(upper - lower, loyalty);
					}
					else if(upper - lower > loyalty)
					{
						System.out.println(upper - lower + " " + cur.node);
						bfs.add(new State(x, lower, upper));
					}
				}
			}
		}
		if(loyalty != -1)
			System.out.println(loyalty);
		else
			System.out.println("Nice work, Dima");
	}
	
	public class State
	{
		public int node;
		public int lower;
		public int upper;
		
		public State(int a, int b, int c)
		{
			node = a;
			lower = b;
			upper = c;
		}
	}
	
	public class Edge
	{
		public int lower;
		public int upper;
		
		public Edge(int a, int b)
		{
			lower = a;
			upper = b;
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
		new D214().run();
	}
}
