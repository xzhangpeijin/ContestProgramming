package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMEls
{	
	public void solve() throws IOException 
	{
		String input = nextLine();
		boolean start = (input.charAt(0) == '*') ? true : false;
		boolean end = (input.charAt(input.length() - 1) == '*') ? true : false;
		ArrayList<String> reg = new ArrayList<String>();
		while(input.indexOf("**") >= 0)
			input = input.replaceAll("[*][*]", "*");
		String[] temp = input.split("[*]");
		for(int x = 0; x < temp.length; x++)
			if(temp[x].length() > 0)
				reg.add(temp[x]);
		int n = nextInt();
		for(int x = 0; x < n; x++)
		{	
			String search = nextLine();
			if(reg.size() == 0)
			{
				System.out.println(search);
			}
			else
			{
				int[] index = new int[reg.size()];
				boolean match = true;
				index[0] = search.indexOf(reg.get(0));
				if(index[0] == -1)
					match = false;
				for(int y = 1; y < reg.size(); y++)
				{
					index[y] = search.indexOf(reg.get(y), index[y - 1] + 1);
					if(index[y] == -1)
						match = false;
				}
				if(!start && index[0] != 0)
					match = false;
				if(!end && search.lastIndexOf(reg.get(reg.size() - 1)) != search.length() - reg.get(reg.size() - 1).length())
					match = false;
				if(match)
					System.out.println(search);
			}
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
		new ACMEls().run();
	}
}
