package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACM1
{	
	public void solve() throws IOException 
	{
		boolean start = true;
		while(start)
		{
			int numteams = nextInt();
			int a = nextInt();
			int b = nextInt();
			if(numteams == 0 && a == 0 && b == 0)
			{
				start = false;
				break;
			}
			
			ArrayList<Team> teams = new ArrayList<Team>();
			for(int x = 0; x < numteams; x++)
			{
				teams.add(new Team(nextInt(), nextInt(), nextInt()));
			}
			Collections.sort(teams);
			
//			for(int x = 0; x < numteams; x++)
//				System.out.println(teams.get(x).dista + " " + teams.get(x).distb);
//			
			Team rec = null;
			boolean ig = false;
			
			int total = 0;
			while(teams.size() > 0)
			{
				Team temp = teams.remove(0);
				if(rec != null && rec == temp)
					ig = true;
				if(a != 0 && b != 0)
				{
					if(ig || temp.dista < temp.distb)
					{
						if(a >= temp.needed)
						{
							a -= temp.needed;
							total += temp.needed * temp.dista;
						}
						else
						{
							temp.needed -= a;
							b -= temp.needed;
							total += a * temp.dista + temp.needed * temp.distb;
							a = 0;
						}
						if(a == 0)
							Collections.sort(teams, new SortB());
					}
					else if(temp.distb < temp.dista)
					{
						if(b >= temp.needed)
						{
							b -= temp.needed;
							total += temp.needed * temp.distb;
						}
						else
						{
							temp.needed -= b;
							a -= temp.needed;
							total += b * temp.distb + temp.needed * temp.dista;
							b = 0;
						}
						if(b == 0)
							Collections.sort(teams, new SortA());
					}
					else
					{
						if(rec == null)
							rec = temp;
						teams.add(temp);
					}
				}
				else
				{
					if(a == 0)
					{
						b -= temp.needed;
						total += temp.needed * temp.distb;
					}
					else if(b == 0)
					{
						a -= temp.needed;
						total += temp.needed * temp.dista;
					}
				}
			}
			System.out.println(total);
		}
	}
	
	public class SortA implements Comparator<Team>
	{
		public int compare(Team arg0, Team arg1)
		{
			return arg0.dista - arg1.dista;
		}	
	}

	public class SortB implements Comparator<Team>
	{
		public int compare(Team arg0, Team arg1)
		{
			return arg0.distb - arg1.distb;
		}	
	}

	public class Team implements Comparable<Team>
	{
		public int needed;
		public int dista;
		public int distb;

		public Team(int needed, int dista, int distb)
		{
			this.needed = needed;
			this.dista = dista;
			this.distb = distb;
		}

		public int compareTo(Team a)
		{
			int result = -1 * Math.abs(dista - distb) + Math.abs(a.dista - a.distb);
				return result;
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
		new ACM1().run();
	}
}
