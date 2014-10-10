package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class C216
{	
	public void solve() throws IOException 
	{
		int n = nextInt();

	}
	
	public class Node
	{
		public Node parent;
		public ArrayList<Node> children = new ArrayList<Node>();
		public int name;
		public int type;
		
		public Node(int name, int type)
		{
			this.name = name;
			this.type = type;
		}
		
		public void setParent(Node a)
		{
			parent = a;
		}
		
		public void addChild(Node a)
		{
			children.add(a);
			a.setParent(this);
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
		new C216().run();
	}
}
