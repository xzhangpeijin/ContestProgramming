package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMBFlip
{	
	public void solve() throws IOException 
	{
		int num = 0;
		while(true)
		{
			num++;
			int n = nextInt();
			int m = nextInt();
			if(n == 0 && m == 0)
				break;
			
			Pile[][] piles = new Pile[n][m];
			for(int x = 0; x < n; x++)
				for(int y = 0; y < m; y++)
					piles[x][y] = new Pile(nextInt());
			
			int left = 0;
			int right = m - 1;
			int top = 0;
			int bot = n - 1;
			String moves = nextLine();
			for(int x = 0; x < moves.length(); x++)
			{
				char move = moves.charAt(x);
				if(move == 'L')
				{
					for(int y = 0; y < n; y++)
						addPile(piles[y][left], piles[y][left + 1]);
					left++;
				}
				if(move == 'R')
				{
					for(int y = 0; y < n; y++)
						addPile(piles[y][right], piles[y][right - 1]);
					right--;
				}
				if(move == 'T')
				{
					for(int y = 0; y < m; y++)
						addPile(piles[top][y], piles[top + 1][y]);
					top++;
				}
				if(move == 'B')
				{
					for(int y = 0; y < m; y++)
						addPile(piles[bot][y], piles[bot - 1][y]);
					bot--;
				}
			}
//			if(top != bot || right != left)
//				System.err.println("err" + top + " " + bot + " " + left + " " + right);
			ArrayList<Integer> out = piles[top][left].cards;
			System.out.print("Case " + num + ":");
			for(int x = 0; x < out.size(); x++)
				if(out.get(x) > 0)
					System.out.print(" " + out.get(x));
			System.out.println();
				
		}
	}
	
	public void addPile(Pile a, Pile b)
	{
		for(int x = a.cards.size() - 1; x >= 0; x--)
			b.cards.add(a.cards.get(x) * -1);
		a.cards.clear();
	}
	
	public class Pile
	{
		public ArrayList<Integer> cards;
		
		public Pile(int val)
		{
			this.cards = new ArrayList<Integer>();
			cards.add(val);
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
		new ACMBFlip().run();
	}
}
