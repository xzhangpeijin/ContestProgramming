package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A204
{	
	public void solve() throws IOException 
	{
		int zeroes = 0;
		int fives = 0;
		int n = nextInt();
		int[] arr = new int[n];
		for(int x = 0; x < n; x++)
		{
			arr[x] = nextInt();
			if(arr[x] == 0)
				zeroes++;
			else
				fives++;
		}
		Arrays.sort(arr);
		
		char[] beg = new char[fives - (fives % 9)];
		for(int x = 0; x < beg.length; x++)
			beg[x] = '5';
		
		char[] end = new char[zeroes];
		for(int x = 0; x < zeroes; x++)
			end[x] = '0';
		
		String ans = new String(beg) + new String(end);
		if(beg.length == 0)
			ans = "0";
		if(zeroes == 0)
			ans = "-1";
		
		System.out.println(ans);

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
		new A204().run();
	}
}
