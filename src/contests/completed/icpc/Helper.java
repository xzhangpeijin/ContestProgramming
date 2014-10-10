package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class Helper
{	
	public void solve() throws IOException 
	{
		long[] data = new long[75];
//		for(int x = 0; x < 75; x++)
//			data[x] = Long.MAX_VALUE;
//		for(long x = 2; x <= 3000000; x++)
//		{
//			int num = countnum(x);
//			if(num != 0 && num <= 75)
//				data[num - 1] = Math.min(data[num - 1], x);
//		}
//		for(int x = 20; x < data.length; x++)
//			System.out.println(x + 1 + " " + data[x]);
		
//		for(int x = 0; x < data.length; x++)
//			System.out.print(data[x] + ", ");
		//System.out.println(countnum(2949120L));
		for(int x = 0; x < 75; x++)
		{
			int a = nextInt();
			long b = Long.valueOf(nextToken());
			System.out.println(a + " " + countnum(b));
			if(a != countnum(b))
				System.out.println("asfd");
		}
	}

	public int countnum(long n)
	{
		int count = 1;
		for(int x = 2; x <= Math.pow(n, 0.5); x++)
		{
			if(n % x == 0)
			{
				count++;
			}
		}
		return count;
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

		br = new BufferedReader( new InputStreamReader( oj ? System.in : new FileInputStream("input.txt")));
		out = new PrintWriter( oj ? System.out : new FileOutputStream("output.txt"));
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException 
	{
		new Helper().run();
	}
}
