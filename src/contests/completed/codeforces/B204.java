package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B204
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int[] arr = new int[n];
		for(int x = 0; x < n; x++)
			arr[x] = nextInt();

		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for(int x = 0; x < n; x++)
		{
			if(arr[x] != 0)
			{
				//System.out.println(arr[x] + ":");
				int diff = 0;
				for(int y = x + 1; y < n; y++)
				{
					if(diff == 0 && arr[y] == arr[x])
					{
						arr[y] = 0;
						diff = y - x;
						y += diff - 1;
						//System.out.println(y + " " + diff);
					}
					else if(diff != 0)
					{
						if(arr[y] != arr[x])
						{
							diff = -1;
							break;
						}
						else
						{
							arr[y] = 0;
							y += diff - 1;
						}
					}
				}
				for(int y = x + 1; y < n; y++)
				{
					if(arr[x] == arr[y])
					{
						diff = -1;
						arr[y] = 0;
					}
				}
				if(diff != -1)
					pairs.add(new Pair(arr[x], diff));
				arr[x] = 0;
			}
		}
		Collections.sort(pairs);
		System.out.println(pairs.size());
		for(int x = 0; x < pairs.size(); x++)
			System.out.println(pairs.get(x).num + " " + pairs.get(x).diff);
	}

	public class Pair implements Comparable<Pair>
	{
		public int num;
		public int diff;

		public Pair(int num, int diff)
		{
			this.num = num;
			this.diff = diff;
		}

		public int compareTo(Pair a)
		{
			return num - a.num;
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
		new B204().run();
	}
}
