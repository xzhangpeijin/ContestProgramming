package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class C215
{	
	public void solve() throws IOException 
	{
		String input = nextLine();
		int m = nextInt();
		for(int x = 0; x < m; x++)
		{
			int l = nextInt();
			int r = nextInt();
			String sub = input.substring(l - 1, r);
			//System.out.println(sub);
			int xcount = 0;
			int ycount = 0;
			int zcount = 0;
			for(int y = 0; y < sub.length(); y++)
				if(sub.charAt(y) == 'x')
					xcount++;
				else if(sub.charAt(y) == 'y')
					ycount++;
				else if(sub.charAt(y) == 'z')
					zcount++;
			//System.out.println(xcount + " " + ycount + " " + zcount);
			int min = Math.min(xcount, ycount);
			min = Math.min(min, zcount);
			xcount -= min;
			ycount -= min;
			zcount -= min;
			if(xcount > 1 || ycount > 1 || zcount > 1)
				System.out.println("NO");
			else
				System.out.println("YES");
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
		new C215().run();
	}
}
