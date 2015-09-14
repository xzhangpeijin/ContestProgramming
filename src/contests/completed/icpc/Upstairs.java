package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Upstairs {
  
  public void solve() throws IOException {
    int n = nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = nextInt();
    }
    
    int max = 0;
    int index = -1;
    for (int i = 0; i < n - 1; i++) {
      int decrease = a[i + 1] - a[i];
      if (i > 0) {
        int oldup = Math.max(0, a[i] - a[i - 1]);
        int newup = Math.max(0, a[i + 1] - a[i - 1]);
        decrease += oldup - newup;
      }
      
      if (i + 2 < n) {
        int oldup = Math.max(0, a[i + 2] - a[i + 1]);
        int newup = Math.max(0, a[i + 2] - a[i]);
        decrease += oldup - newup;
      }
      
      if (decrease > max) {
        max = decrease;
        index = i + 1;
      }
    }
    
    System.out.println(index);
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
    new Upstairs().run();
  }
}
