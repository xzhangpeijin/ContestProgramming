package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMGVampire
{	
	public void solve() throws IOException 
	{
		int num = 0;
		while(true)
		{
			num++;
			int n = nextInt();
			int o = nextInt();
			int m = nextInt();
			if(n == 0 && o == 0 && m == 0)
				break;
			char[][] grid = new char[101][101];
			for(int x = 0; x < 101; x++)
				for(int y = 0; y < 101; y++)
					grid[x][y] = ' ';
			ArrayList<int[]> vampires = new ArrayList<int[]>();
			for(int x = 0; x < n; x++)
			{
				int[] co = new int[2];
				co[0] = nextInt();
				co[1] = nextInt();
				vampires.add(co);
			}
			for(int x = 0; x < o; x++)
			{
				int xco = nextInt();
				int yco = nextInt();
				grid[xco][yco] = 'M';
			}
			for(int x = 0; x < m; x++)
			{
				char dir = nextToken().charAt(0);
				int xstart = nextInt();
				int ystart = nextInt();
				int xend = nextInt();
				int yend = nextInt();
				if(xstart == xend)
				{
					for(int y = Math.min(ystart, yend); y <= Math.max(ystart, yend); y++)
						grid[xstart][y] = dir;
				}
				else if(ystart == yend)
				{
					for(int y = Math.min(xstart, xend); y <= Math.max(xstart, xend); y++)
					{
						grid[y][ystart] = dir;
					}
				}
			}
//			System.out.println();
//			for(int x = 0; x < 8; x++)
//			{
//				for(int y = 0; y < 7; y++)
//					System.out.print(grid[x][y] + " ");
//				System.out.println();
//			}
			System.out.println("Case " + num + ":");
			boolean any = false;
			for(int x = 0; x < vampires.size(); x++)
			{
				boolean found = false;
				String output = "vampire " + (x + 1);
				int xco = vampires.get(x)[0];
				int yco = vampires.get(x)[1];
				
				int east = xco;
				while(east < 101)
				{
					if(grid[east][yco] == 'W')
					{
						found = true;
						output += " east";
					}
					if(grid[east][yco] != ' ')
						break;
					east++;
				}
				
				int north = yco;
				while(north < 101)
				{
					if(grid[xco][north] == 'S')
					{
						found = true;
						output += " north";
					}
					if(grid[xco][north] != ' ')
						break;
					north++;
				}
				
				int south = yco;
				while(south >= 0)
				{
					if(grid[xco][south] == 'N')
					{
						found = true;
						output += " south";
					}
					if(grid[xco][south] != ' ')
						break;
					south--;
				}
				
				int west = xco;
				while(west >= 0)
				{
					if(grid[west][yco] == 'E')
					{
						found = true;
						output += " west";
					}
					if(grid[west][yco] != ' ')
						break;
					west--;
				}
				
				if(found)
				{
					System.out.println(output);
					any = true;
				}
			}
			if(!any)
				System.out.println("none");
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
		new ACMGVampire().run();
	}
}
