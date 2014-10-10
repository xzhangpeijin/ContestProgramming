package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class B203
{	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int[] type = new int[n];
		int[] a = new int[n];
		for(int x = 0; x < n; x++)
			type[x] = nextInt();
		for(int x = 0; x < n; x++)
			a[x] = nextInt();
		
		ArrayList<Integer> occur = new ArrayList<Integer>();
		ArrayList<Integer> dup = new ArrayList<Integer>();
		for(int x = 0; x < n; x++)
		{
			if(occur.contains(a[x]))
			{
				if(!dup.contains(a[x]))
					dup.add(a[x]);
			}
			else
				occur.add(a[x]);
		}
		for(int x = 0; x < n; x++)
			if(dup.contains(a[x]))
				a[x] = 0;

		ArrayList<Integer> maxstring = new ArrayList<Integer>();		
		for(int x = 0; x < n; x++)
		{
			if(type[x] == 1)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(x + 1);
				int index = x;
				while(index > 0 && a[index] == index)
				{
					index--;
					temp.add(0, index + 1);
				}
				if(temp.size() > maxstring.size())
					maxstring = temp;
			}
		}
		
		out.println(maxstring.size());
		for(int x = 0; x < maxstring.size(); x++)
			out.print(maxstring.get(x) + " ");
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
		new B203().run();
	}
}
