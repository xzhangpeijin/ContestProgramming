package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class PiggyBanks
{	
  public class State {
    public int left;
    public int right;
    public int primes;
    
    public State(int left, int right, int primes) {
      this.left = left;
      this.right = right;
      this.primes = primes;
    }
  }
  
  boolean[] prime = new boolean[1000000];
  
  public int combine(int left, int right) {
    String combined = new StringBuilder().append(left).append(right).toString();
    return Integer.parseInt(combined);
  }
  
  public void makePrimes() {
    for (int x = 2; x < 1000000; x++) 
      prime[x] = true;
    
    for (int x = 2; x < 1000000; x++) {
      if (prime[x]) {
        int sum = 2 * x;
        while (sum < 1000000) { 
          prime[sum] = false;
          sum += x;
        }
      }
    }
  }
  
	public void solve() throws IOException 
	{
	  makePrimes();
	  
	  int n = nextInt();
	  int left = 1, right = 1, primes = 0;
	  
	  int[][] dp = new int[n][n];
	  dp[0][0] = 0;
	  Queue<State> bfs = new LinkedList<State>();
	  bfs.add(new State(left, right, primes));

	  while(bfs.size() > 0) {
	    State cur = bfs.poll();
	    if (cur.primes == dp[cur.left - 1][cur.right - 1]) {
	      if (cur.left < n) {
	        int leftprimes = cur.primes;
	        if (prime[combine(cur.left + 1, cur.right)]) {
	          leftprimes++;
	        }

	        if (leftprimes > dp[cur.left][cur.right - 1]) {
	          bfs.add(new State(cur.left + 1, cur.right, leftprimes));
	          dp[cur.left][cur.right - 1] = leftprimes;
	        }
	      }
	      if (cur.right < n - 1) {
	        int rightprimes = cur.primes;
	        if (prime[combine(cur.left, cur.right + 2)]) {
	          rightprimes++;
	        }

	        if (rightprimes > dp[cur.left - 1][cur.right + 1]) {
	          bfs.add(new State(cur.left, cur.right + 2, rightprimes));
	          dp[cur.left - 1][cur.right + 1] = rightprimes;
	        }
	      }
	    }
	  }
	  
	  int max = -1;
	  for (int x = 0; x < n; x++) {
	    for (int y = 0; y < n; y++) {
	      if (dp[x][y] > max) {
	        max = dp[x][y];
	      }
	    }
	  }
	  System.out.println(max);
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
		new PiggyBanks().run();
	}
}
