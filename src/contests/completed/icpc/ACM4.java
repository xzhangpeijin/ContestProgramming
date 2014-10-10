package contests.completed.icpc;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class ACM4
{	
	public void solve() throws IOException 
	{
		boolean start = true;
		while(start)
		{
			int n = nextInt();
			if(n == 0)
			{
				start = false;
				break;
			}
			ArrayList<int[]> coordinates = new ArrayList<int[]>();
			for(int x = 0; x < n; x++)
			{
				int[] temp = new int[2];
				temp[0] = nextInt();
				temp[1] = nextInt();
				coordinates.add(temp);
			}

			ArrayList<ArrayList<Path>> paths = new ArrayList<ArrayList<Path>>();
			for(int x = 0; x < coordinates.size(); x++)
			{
				ArrayList<Path> temp = new ArrayList<Path>();
				for(int y = 0; y < coordinates.size(); y++)
				{
					if(x == y)
						temp.add(new Path(x, x, Double.MAX_VALUE));
					else
					{
						int[] point1 = coordinates.get(x);
						int[] point2 = coordinates.get(y);
						int xdist = Math.abs(point1[0] - point2[0]);
						int ydist = Math.abs(point1[1] - point2[1]);
						double distance = Math.pow(xdist*xdist + ydist*ydist, 0.5);
						temp.add(new Path(x, y, distance));
					}
				}
				Collections.sort(temp);
//				for(int y = 0; y < temp.size(); y++)
//					System.out.println(temp.get(y).distance);
//				System.out.println();
				paths.add(temp);
			}

			ArrayList<Integer> used = new ArrayList<Integer>();
			double total = 0;
			int loc = 0;
			used.add(loc);
			while(used.size() < coordinates.size())
			{
				//System.out.println(coordinates.get(loc)[0] + " " + coordinates.get(loc)[1]);
				ArrayList<Path> curpaths = paths.get(loc);
				while(curpaths.size() > 0)
				{
					Path p = curpaths.remove(0);
					if(!used.contains(p.node1) || !used.contains(p.node2))
					{
						total += p.distance;
						if(!used.contains(p.node1))
						{
							used.add(p.node1);
							loc = p.node1;
						}
						else
						{
							used.add(p.node2);
							loc = p.node2;
						}
						break;
					}
				}
			}
			
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println(df.format((double)Math.round(total * 100) / 100));
		}
	}

	public class Path implements Comparable<Path>
	{
		public int node1;
		public int node2;
		public double distance;

		public Path(int node1, int node2, double distance)
		{
			this.node1 = node1;
			this.node2 = node2;
			this.distance = distance;
		}

		public int compareTo(Path a)
		{
			return (int) (distance - a.distance);
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
		new ACM4().run();
	}
}
