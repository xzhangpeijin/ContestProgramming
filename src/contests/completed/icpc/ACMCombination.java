package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACMCombination {
  public void solve() throws IOException {
    while (true) {
      int n = nextInt();
      int t1 = nextInt();
      int t2 = nextInt();
      int t3 = nextInt();
      if (n == 0 && t1 == 0 && t2 == 0 && t3 == 0)
        break;

      int total = 4 * n - 1;
      if (t1 < t2)
        total += t2 - t1;
      else
        total += n + t2 - t1;
      if (t2 > t3)
        total += t2 - t3;
      else
        total += n + t2 - t3;
      System.out.println(total);
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
    new ACMCombination().run();
  }
}
