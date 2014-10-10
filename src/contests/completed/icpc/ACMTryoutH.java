package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMTryoutH
{	
	public void solve() throws IOException 
	{
		int num = 1;
		while(true)
		{
			int vertices = nextInt();
			int edges = nextInt();
			if(vertices == 0 && edges == 0)
				break;
			
			ArrayList<ArrayList<Integer>> trees = new ArrayList<ArrayList<Integer>>();
			ArrayList<Boolean> istree = new ArrayList<Boolean>();
			
			for(int x = 0; x < edges; x++)
			{
				int a = nextInt();
				int b = nextInt();
				boolean found = false;
				for(int y = 0; y < trees.size(); y++)
				{
					if(trees.get(y).contains(a) && !trees.get(y).contains(b))
					{
						trees.get(y).add(b);
						found = true;
					}
					else if(!trees.get(y).contains(a) && trees.get(y).contains(b))
					{
						trees.get(y).add(a);
						found = true;
					}
					else if(trees.get(y).contains(a) && trees.get(y).contains(b))
					{
						istree.set(y, new Boolean(false));
						found = true;
					}
				}
				if(!found)
				{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(a);
					temp.add(b);
					trees.add(temp);
					istree.add(new Boolean(true));
				}

			}
			
			HashSet<Integer> used = new HashSet<Integer>();
			int numtrees = 0;
			for(int x = 0; x < trees.size(); x++)
			{
				for(int y = 0; y < trees.get(x).size(); y++)
					used.add(trees.get(x).get(y));
				if(istree.get(x))
					numtrees++;
			}
			numtrees += vertices - used.size();
			System.out.print("Case " + num + ": ");
			if(numtrees == 0)
				System.out.println("No trees.");
			else if(numtrees == 1)
				System.out.println("There is one tree.");
			else
				System.out.println("A forest of " + numtrees + " trees.");
			
			num++;
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
		new ACMTryoutH().run();
	}
}
