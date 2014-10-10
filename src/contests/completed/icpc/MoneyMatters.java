package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class MoneyMatters
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int m = nextInt();

		int[] owe = new int[n];
		boolean[][] friendship = new boolean[n][n];

		for (int x = 0; x < n; x++) {
			owe[x] = nextInt();
		}

		for (int x = 0; x < m; x++) {
			int from = nextInt();
			int to = nextInt();
			friendship[from][to] = true;
			friendship[to][from] = true;
		}

		ArrayList<Integer> remain = new ArrayList<Integer>(n);
		for (int x = 0; x < n; x++) {
			remain.add(x);
		}

		while(remain.size() > 0) {
			int start = remain.remove(0);

			HashSet<Integer> visited = new HashSet<Integer>();
			Queue<Integer> active = new LinkedList<Integer>();
			visited.add(start);
			active.add(start);

			long total = 0;
			while(active.size() > 0) {
				Integer node = active.poll();
				remain.remove(new Integer(node));
				total += owe[node];
				for (int x = 0; x < n; x++) {
					if (!visited.contains(x) && friendship[node][x]) {
						visited.add(x);
						active.add(x);
					}
				}
			}
			if (total != 0) {
				System.out.println("IMPOSSIBLE");
				return;
			}
		}
		System.out.println("POSSIBLE");
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
		new MoneyMatters().run();
	}
}
