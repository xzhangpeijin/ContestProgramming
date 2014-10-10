package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMCcookie
{	
	public void solve() throws IOException 
	{
		PriorityQueue<Integer> minqueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxqueue = new PriorityQueue<Integer>(11,Collections.reverseOrder());

		//ArrayList<Integer> cookies = new ArrayList<Integer>();
		String nextline = "";
		while((nextline = nextLine()) != null)
		{
			if(nextline.equals("#"))
			{
				if(minqueue.size() >= maxqueue.size())
					System.out.println(minqueue.remove());
				else
					System.out.println(maxqueue.remove());
			}
			else
			{
				Integer a = Integer.valueOf(nextline);
				minqueue.offer(a);
			}
			if(minqueue.size() > maxqueue.size() + 1)
				maxqueue.offer(minqueue.remove());
			if(maxqueue.size() > minqueue.size() + 1)
				minqueue.offer(maxqueue.remove());
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
		br = new BufferedReader( new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException 
	{
		new ACMCcookie().run();
	}
}
