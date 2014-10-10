package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class FamilyFortune
{	
	public LinkedList<Integer>[] children;
	public int[] worths;
	
	public void solve() throws IOException 
	{
		int n, k;
		while ((n = nextInt()) != 0 && (k = nextInt()) != 0) {
			children = new LinkedList[n];
			worths = new int[n];
			
			for (int x = 0; x < n; x++) {
				children[x] = new LinkedList<Integer>();
			}
			
			int root = -1;
			for (int x = 0; x < n; x++) {
				int p = nextInt();
				int w = nextInt();
				if (p == 0) {
					root = x;
				} else {
					children[p - 1].add(x);
				}
				worths[x] = w;
			}
			
			int[] max = new int[k];
			max = recurse(root, max);
			
			System.out.println(max[k - 1]);
		}
	}
	
	public int[] recurse (int node, int[] max) {
		int[] newmax = max.clone();
		int[] childmax = max.clone();
		
		for (int child : children[node]) {
			childmax = recurse(child, childmax);
		}
		
		for (int x = max.length - 1; x >= 0; x--) {
			if (x != 0 && newmax[x - 1] > 0) {
				newmax[x] = Math.max(newmax[x - 1] + worths[node], childmax[x]);
			} else if (x == 0) {
				newmax[x] = Math.max(worths[node], childmax[x]);
			} else {
				newmax[x] = childmax[x];
			}
		}
		
		return newmax;
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
		new FamilyFortune().run();
	}
}
