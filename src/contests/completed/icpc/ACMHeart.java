package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMHeart
{	
	public void solve() throws IOException 
	{
		while(true)
		{
			int n = nextInt();
			int k = nextInt();
			if(n == 0 && k == 0)
				break;
			
			ArrayList<City> cities = new ArrayList<City>();
			int total = 0;
			
			for(int x = 0; x < n; x++)
			{
				int garrison = nextInt();
				int connect = nextInt();
				int[] connected = new int[connect];
				for(int y = 0; y < connect; y++)
					connected[y] = nextInt();
				cities.add(new City(x, garrison, connected));
				total += garrison;
			}
			
			for(int x = 0; x < n; x++)
			{
				City a = cities.get(x);
				int[] connect = a.connect;
				for(int y = 0; y < connect.length; y++)
				{
					cities.get(connect[y]).available += a.garrison;
				}
			}
			
			Collections.sort(cities);
			
			while(cities.size() > 0 && cities.get(0).available < k)
			{
				int garrison = cities.get(0).garrison;
				int[] connect = cities.get(0).connect;
				for(int x = 1; x < cities.size(); x++)
				{
					for(int y = 0; y < connect.length; y++)
					{
						if(cities.get(x).index == connect[y])
							cities.get(x).available -= garrison;
					}
				}
				cities.remove(0);
				total -= garrison;
				Collections.sort(cities);
			}
			
			System.out.println(cities.size() + " " + total);
		}
	}
	
	public class City implements Comparable<City>
	{
		public int garrison;
		public int available;
		public int[] connect;
		public int index;
		
		public City(int index, int garrison, int[] connect)
		{
			this.index = index;
			this.garrison = garrison;
			this.available = garrison;
			this.connect = connect;
		}
		
		public int compareTo(City a)
		{
			return available - a.available;
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
		new ACMHeart().run();
	}
}
