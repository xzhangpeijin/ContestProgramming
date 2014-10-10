package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B198
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		ArrayList<Integer> data = new ArrayList<Integer>();
		for(int x = 0; x < n; x++)
			data.add(nextInt());

		while(!isSorted(data))
		{
			int maxcount = 0;
			int del = -1;
			for(int x = 0; x < data.size(); x++)
			{
				int count = 0;
				for(int y = 0; y < data.size(); y++)
				{
					if(x < y && data.get(x) > data.get(y))
						count++;
					if(x > y && data.get(x) < data.get(y))
						count++;
				}
				if(count > maxcount)
				{
					del = x;
					maxcount = count;
				}
			}
			data.remove(del);
		}
		out.println(data.size());
	}

	public boolean isSorted(ArrayList<Integer> data)
	{
		for(int x = 0; x < data.size() - 1; x++)
			if(data.get(x) > data.get(x + 1))
				return false;
		return true;
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
		new B198().run();
	}
}
