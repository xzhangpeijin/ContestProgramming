package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACMTryoutB
{	
    public void solve() throws IOException 
    {
    	int cases = nextInt();
        for(int q = 0; q < cases; q++)
        {
        	int scrapers = nextInt();
        	int tests = nextInt();
        	int[] skyscrapers = new int[scrapers];
        	int[] queries = new int[tests];
        	for(int x = 0; x < scrapers; x++)
        		skyscrapers[x] = nextInt();
        	for(int x = 0; x < tests; x++)
        		queries[x] = nextInt();
        	
        	ArrayList<Integer> peaks = new ArrayList<Integer>();
        	ArrayList<Integer> valleys = new ArrayList<Integer>();
        	
        	for(int x = 1; x < scrapers - 1; x++)
        	{
        		if(skyscrapers[x] > skyscrapers[x - 1] && skyscrapers[x] >= skyscrapers[x + 1])
        			peaks.add(skyscrapers[x]);
        		else if(skyscrapers[x] < skyscrapers[x - 1] && skyscrapers[x] <= skyscrapers[x + 1])
        			valleys.add(skyscrapers[x]);
        	}
        	
        	if(scrapers > 1)
        	{
        		if(skyscrapers[0] > skyscrapers[1])
        			peaks.add(skyscrapers[0]);
        		if(skyscrapers[scrapers - 1] > skyscrapers[scrapers - 2])
        			peaks.add(skyscrapers[scrapers - 1]);
        	}
        	else
        		peaks.add(skyscrapers[0]);
        	
        	Collections.sort(peaks);
        	Collections.sort(valleys);
        	
        	int regions = 1;
        	for(int x = 0; x < tests; x++)
        	{
        		while(peaks.size() > 0 && peaks.get(0) <= queries[x])
        		{
        			peaks.remove(0);
        			regions--;
        		}
        		
        		while(valleys.size() > 0 && valleys.get(0) <= queries[x])
        		{
        			valleys.remove(0);
        			regions++;
        		}
        		
        		System.out.print(regions + " ");
        	}
        	
        	System.out.println();
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
        new ACMTryoutB().run();
    }
}
