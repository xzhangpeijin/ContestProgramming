package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A199
{	
    public void solve() throws IOException 
    {
       int n = nextInt();
       int[] counts = new int[7];
       for(int x= 0; x < n; x++)
    	   counts[nextInt() - 1]++;
      
       if(counts[4] != 0)
    	   System.out.println(-1);
       else if(counts[6] != 0)
    	   System.out.println(-1);
       else
       {
    	   int three = counts[2];
    	   int six = counts[5] - three;
    	   int two = counts[1] - six;
    	   counts[0] -= two;
    	   counts[0] -= three;
    	   counts[0] -= six;
    	   counts[3] -= two;
    	   if(counts[0] != 0 || counts[3] != 0 || two < 0 || three < 0 || six < 0)
    		   System.out.println(-1);
    	   else
    	   {
    		   for(int x = 0; x < two; x++)
    			   System.out.println("1 2 4");
    		   for(int x = 0; x < six; x++)
    			   System.out.println("1 2 6");
    		   for(int x = 0; x < three; x++)
    			   System.out.println("1 3 6");
    	   }
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
        new A199().run();
    }
}
