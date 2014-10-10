package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class E98
{	
    public void solve() throws IOException 
    {
    	String input = nextToken().toUpperCase();
    	int[] cumsum = new int[input.length() + 1];
    	cumsum[0] = 0;
    	int start = -1;
    	for(int x = 0; x < input.length(); x++)
    	{
    		cumsum[x + 1] = cumsum[x] + Vowel(input.charAt(x));
    		if(start == -1 && Vowel(input.charAt(x)) == 2)
    			start = x;
    	}
    	
    	System.out.println(start);
    	
    	int maxlen = 0;
    	int count = 0;
    	for(int x = start; x < input.length(); x++)
    	{
    		for(int y = input.length(); y >= x + maxlen; y--)
    		{
    			if(cumsum[y] - cumsum[x] >= 0)
    			{
    				if(y - x == maxlen)
    					count++;
    				else
    				{
    					maxlen = y - x;
    					if(x == 0)
    						maxlen = y - x + Math.min(cumsum[y] - cumsum[x], start);
    					count = 1;
    				}
    				break;
    			}
    		}
    	}
    	
    	if(maxlen == 0)
    		System.out.println("No solution");
    	else
    		System.out.println(maxlen + " " + count);
    	
//    	for(int x = 0; x < input.length() + 1; x++)
//    		System.out.println(cumsum[x]);
    	
    }
    
    public int Vowel(char a)
    {
    	switch(a)
    	{
    		case 'A': return -1;
    		case 'E': return -1;
    		case 'I': return -1;
    		case 'O': return -1;
    		case 'U': return -1;
    		default: return 2;
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
        new E98().run();
    }
}
