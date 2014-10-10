package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMDefense
{	
	public void solve() throws IOException 
	{
		int tests = nextInt();
		for(int t = 0; t < tests; t++)
		{
			int towers = nextInt();
			ArrayList<ArrayList<Integer>> consec = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for(int x = 0; x < towers; x++)
			{
				int tower = nextInt();
				if(cur.size() == 0 || cur.get(cur.size() - 1) < tower)
				{
					cur.add(tower);
				}
				else
				{
					if(cur.size() > 1)
						consec.add(cur);
					cur = new ArrayList<Integer>();
					cur.add(tower);
				}
			}
			if(cur.size() > 1)
				consec.add(cur);

			int largest = consec.get(0).size();
			for(int x = 0; x < consec.size() - 1; x++)
			{
				ArrayList<Integer> start = consec.get(x);
				for(int y = x + 1; y < consec.size(); y++)
				{
					if(start.size() + consec.get(y).size() > largest)
					{
						int length = 0;
						int big = consec.get(y).get(0);
						for(int z = 0; z < start.size(); z++)
							if(start.get(z) < big)
								length++;
						length += consec.get(y).size();
						if(length > largest)
							largest = length;
					}
				}
			}

			System.out.println(largest);
			//			for(int x = 0; x < consec.size(); x++)
			//			{
			//				ArrayList<Integer> string = consec.get(x);
			//				for(int y = 0; y < string.size(); y++)
			//					System.out.print(string.get(y) + " ");
			//				System.out.println();
			//			}
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
		new ACMDefense().run();
	}
}
