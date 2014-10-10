package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class ACM5
{	
	int[][] maxs;
    public void solve() throws IOException 
    {
       boolean start = true;
       while(start)
       {
    	   int width = nextInt();
    	   int height = nextInt();
    	   if(width == 0 && height == 0)
    	   {
    		   start = false;
    		   break;
    	   }
    	   int[][] arr = new int[width][height];
    	   maxs = new int[width][height];
    	   for(int x = 0; x < width; x++)
    	   {
    		   for(int y = 0; y < height; y++)
    		   {
    			   arr[x][y] = nextInt();
    		   }
    	   }
    	   int max = 0;
    	   for(int x = 0; x < width - max; x++)
    	   {
    		   for(int y = 0; y < height - max; y++)
    		   {
    			   if(arr[x][y] == 1)
    			   {
    				  // System.out.println(x + " " + y + " " + maxsq(arr, x, y));
    				   max = Math.max(max, maxsq(arr, x, y));
    			   }
    		   }
    	   }
    	   System.out.println(max);
//    	   for(int x = 0; x < width; x++)
//    	   {
//    		   for(int y = 0; y < height; y++)
//    			   System.out.print(maxs[x][y] + " ");
//    		   System.out.println();
//    	   }
       }
    }
    
    public int maxsq(int[][] arr, int x, int y)
    {
    	if(maxs[x][y] != 0)
    		return maxs[x][y];
    	if(x >= arr.length - 1 || y >= arr[0].length - 1)
    		return maxs[x][y] = 1;
    	if(arr[x + 1][y] == 0 || arr[x + 1][y + 1] == 0 || arr[x][y + 1] == 0)
    		return maxs[x][y] = 1;
    	
    	return maxs[x][y] = 1 + Math.min(Math.min(maxsq(arr, x, y + 1), maxsq(arr, x + 1, y + 1)), maxsq(arr, x + 1, y));
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
        new ACM5().run();
    }
}
