package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class D269
{	
	
	class KnuthMorrisPratt
	{
	    private int[] failure;
	    private final String text;
	    private final String pat;
	    
	    public KnuthMorrisPratt(String text, String pat)
	    {
	        /** pre construct failure array for a pattern **/
	        failure = new int[pat.length()];
	        fail(pat);
	        this.text = text;
	        this.pat = pat;
	    }
	    
	    public int run() {
        fail(pat);
        /** find match **/
        int pos = posMatch(text, pat);
        if (pos == -1)
            System.out.println("\nNo match found");
        else
            System.out.println("\nMatch found at index "+ pos);
        return pos;
	    }
	    
	    /** Failure function for a pattern **/
	    private void fail(String pat)
	    {
	        int n = pat.length();
	        failure[0] = -1;
	        for (int j = 1; j < n; j++)
	        {
	            int i = failure[j - 1];
	            while ((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0)
	                i = failure[i];
	            if (pat.charAt(j) == pat.charAt(i + 1))
	                failure[j] = i + 1;
	            else
	                failure[j] = -1;
	        }
	    }
	    /** Function to find match for a pattern **/
	    private int posMatch(String text, String pat)
	    {
	        int i = 0, j = 0;
	        int lens = text.length();
	        int lenp = pat.length();
	        while (i < lens && j < lenp)
	        {
	            if (text.charAt(i) == pat.charAt(j))
	            {
	                i++;
	                j++;
	            }
	            else if (j == 0)
	                i++;
	            else
	                j = failure[j - 1] + 1;
	        }
	        return ((j == lenp) ? (i - lenp) : -1);
	    }
	}
	
	public void solve() throws IOException 
	{
		int n = nextInt();
		int w = nextInt();
		int[] heights = new int[n];
		for (int x = 0; x < n; x++) {
			heights[x] = nextInt();
		}
		
		int prev = -1;
		int[] pattern = new int[w - 1];
		for (int x = 0; x < w; x++) {
			int val = nextInt();
			if (x != 0) {
				pattern[x - 1] = val - prev;
			}
			prev = val;
		}
		
		if (w == 1) {
			System.out.println(n);
			return;
		}

		int total = 0;
		for (int x = 0; x <= n - w; x++) {
			for (int y = x + 1; y < x + w; y++) {
				if (heights[y] - heights[y - 1] != pattern[y - x - 1]) {
					break;
				}
				if (y == x + w - 1) {
					total++;
				}
			}
		}
		System.out.println(total);
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
		new D269().run();
	}
}
