package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G386 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int t = nextInt();
    int k = nextInt();
    
    int[] distances = new int[t];
    for (int i = 0; i < t; i++) {
      distances[i] = nextInt();
      if (distances[i] == 0) {
        System.out.println(-1);
        return;
      }
    }
    
    if (k > n - t) {
      System.out.println(-1);
      return;
    }
    
    int botcount = distances[t-1];
    k -= distances[t-1];
    for (int i = t - 2; i >= 0; i--) {
      int shrinkage = Math.max(0, distances[i] - botcount);
      k -= shrinkage;
      botcount = distances[i];
    }
    
    if (k < 0) {
      System.out.println(-1);
      return;
    }
    
    int nextid = 2;
        
    System.out.println(n);
    for (int i = t - 1; i >= 0; i--) {
      boolean skip = false;
      int nextlayer = nextid + distances[i];
      for (int j = 0; j < distances[i]; j++) {
        if (i != 0) {
          int topnode = (j >= distances[i-1]) ? 0 : j;
          if (skip && topnode != 0) {
            System.out.println(nextid++ + " " + nextlayer);
            k--;
          } else {
            System.out.println(nextid++ + " " + (nextlayer + topnode));
          }
          skip = (k > 0);
        } else {
          System.out.println(nextid++ + " 1");
        }
      }
    }
  }

  public BufferedReader br;
  public StringTokenizer st;
  public PrintWriter out;

  public String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
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

  public long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  public double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  public void run() throws IOException {
    boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    oj = true;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new G386().run();
  }
}
