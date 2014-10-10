package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A261 {
  public void solve() throws IOException {
    int x0 = nextInt();
    int y0 = nextInt();
    int x1 = nextInt();
    int y1 = nextInt();

    int xdiff = Math.abs(x0 - x1);
    int ydiff = Math.abs(y0 - y1);

    if (xdiff == 0) {
      x0 += ydiff;
      x1 += ydiff;
    } else if (ydiff == 0) {
      y0 += xdiff;
      y1 += xdiff;
    } else if (xdiff == ydiff) {
      int botx = Math.min(x0, x1);
      int boty = Math.min(y0, y1);
      x0 = botx;
      y0 = boty + ydiff;
      x1 = botx + ydiff;
      y1 = boty;
    } else {
      System.out.println(-1);
      return;
    }
    System.out.println(x0 + " " + y0 + " " + x1 + " " + y1);

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
    new A261().run();
  }
}
