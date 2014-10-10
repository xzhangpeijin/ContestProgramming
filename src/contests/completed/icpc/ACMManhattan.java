package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMManhattan
{	
	public void solve() throws IOException 
	{
		int tests = nextInt();
		for(int t = 0; t < tests; t++)
		{
			ArrayList<String> buildings = new ArrayList<String>();
			ArrayList<int[]> coordinates = new ArrayList<int[]>();
			ArrayList<Distance> distances = new ArrayList<Distance>();
			
			int updates = nextInt();

			for(int x = 0; x < updates; x++)
			{
				int type = nextInt();
				String name = nextToken();
				if(type == 1)
				{
					int[] coor = new int[2];
					coor[0] = nextInt();
					coor[1] = nextInt();
					int index = buildings.size();
					
					for(int y = 0; y < coordinates.size(); y++)
					{
						distances.add(new Distance(getDist(coor, coordinates.get(y)), index, y));
					}
					Collections.sort(distances);
					
					buildings.add(name);
					coordinates.add(coor);
				}
				else
				{
					int index = buildings.indexOf(name);
					buildings.remove(index);
					coordinates.remove(index);
					
					for(int y = 0; y < distances.size(); y++)
					{
						if(distances.get(y).index1 == index || distances.get(y).index2 == index)
						{
							distances.remove(y);
							y--;
						}
					}
				}
				
				if(buildings.size() <= 1)
					System.out.println(buildings.size() - 1);
				else
				{
					System.out.println(distances.get(0).distance);
				}
			}
		}
	}
	
	public int getDist(int[] co1, int[] co2)
	{	
		return Math.abs(co1[0] - co2[0]) + Math.abs(co1[1] - co2[1]);
	}
	
	public class Distance implements Comparable<Distance>
	{
		int distance;
		int index1;
		int index2;
		
		public Distance(int d, int index1, int index2)
		{
			this.distance = d;
			this.index1 = index1;
			this.index2 = index2;
		}
		
		public int compareTo(Distance a)
		{
			return a.distance - distance;
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
		new ACMManhattan().run();
	}
}
