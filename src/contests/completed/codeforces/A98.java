package contests.completed.codeforces;

import java.io.*;
import java.util.*;

public class A98
{	
    public void solve() throws IOException 
    {
       String input = nextToken();
       
       int count = 0;
       char type = '0';
       int trips = 0;
       for(int x = 0; x < input.length(); x++)
       {
    	   if(count == 0)
    	   {
    		   type = input.charAt(x);
    		   count++;
    	   }
    	   else if(type == input.charAt(x))
    	   {
    		   count++;
    		   if(count == 5)
    		   {
    			   count = 0;
    			   trips++;
    			   type = '0';
    		   }
    	   }
    	   else
    	   {
    		   trips++;
    		   count = 1;
    		   type = input.charAt(x);
    	   }
       }
       if(count != 0)
    	   trips++;
       
       System.out.println(trips);
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
        new A98().run();
    }
}
