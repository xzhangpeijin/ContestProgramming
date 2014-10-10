package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class Triangle
{	
	public int[][] values;
	public int[][] num;
	
	public void solve() throws IOException 
	{
		int n = nextInt();
		num = new int[n][];
		values = new int[n][];
		for(int x = 0; x < n; x++)
		{
			num[x] = new int[x + 1];
			values[x] = new int[x + 1];
			for(int y = 0; y < x + 1; y++)
			{	
				num[x][y] = nextInt();
				values[x][y] = -1;
			}
		}
//		for(int x = 0; x < num.length; x++)
//		{
//			for(int y = 0; y < num[x].length; y++)
//				System.out.print(num[x][y] + " ");
//			System.out.println();
//		}

		System.out.println(getVal(0, 0));
	}

	public int getVal(int x, int y)
	{
		if(values[x][y] == -1)
		{
			if(x != values.length - 1)
			{
				return values[x][y] = num[x][y] + Math.max(getVal(x + 1, y), getVal(x + 1, y + 1)); 
			}
			else
				return values[x][y] = num[x][y];
		}
		else
			return values[x][y];
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
		new Triangle().run();
	}
}
