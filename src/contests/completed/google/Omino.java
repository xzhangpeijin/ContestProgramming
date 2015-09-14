package contests.completed.google;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Omino {
  
  public void solve() throws IOException {
    int tests = nextInt();
    for (int t = 0; t < tests; t++) {
      int x = nextInt();
      int r = nextInt();
      int c = nextInt();
      int area = r * c;
      boolean possible = (area % x == 0);
      if (x == 4) {
        possible &= (Math.min(r, c) >= 3);
      }
      if (x == 3) {
        possible &= (Math.min(r, c) >= 2);
      }
      out.format("Case #%d: %s%n", t + 1, (possible) ? "GABRIEL" : "RICHARD");
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
    oj = false;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new Omino().run();
  }
}
