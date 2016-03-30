package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Ilya {
  
  public void solve() throws IOException {
    int n = nextInt();
    int k = nextInt();
    
    int tot = 0;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
      tot += arr[i];
    }
    if (2 * k >= n) {
      System.out.println(tot);
      return;
    }
        
    int ksum = 0;
    for (int i = 0; i < k; i++) {
      ksum += arr[i];
    }
    int kmax = ksum;
    
    int cursum = 0; 
    for (int i = k; i < 2 * k; i++) {
      cursum += arr[i];
    }
    
    int maxtot = kmax + cursum;
    for (int i = k + 1; i <= n - k; i++) {
      ksum += arr[i - 1];
      ksum -= arr[i - k - 1];
      kmax = Math.max(ksum, kmax);
      
      cursum -= arr[i - 1];
      cursum += arr[i + k - 1];
      maxtot = Math.max(maxtot, cursum + kmax);
    }
    
    System.out.println(maxtot);
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
    new Ilya().run();
  }
}
