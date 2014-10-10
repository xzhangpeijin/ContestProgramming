package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A203 {
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int[] a = new int[n];
    int[] b = new int[m];

    for (int x = 0; x < n; x++)
      a[x] = nextInt();
    for (int x = 0; x < m; x++)
      b[x] = nextInt();

    Arrays.sort(a);
    Arrays.sort(b);

    if (a[n - 1] >= b[0]) {
      out.println(-1);
      return;
    }

    if (n == 1) {
      if (a[0] * 2 < b[0]) {
        out.println(a[0] * 2);
      } else
        out.println(-1);
      return;
    }

    if (2 * a[0] >= b[0]) {
      out.println(-1);
      return;
    }

    out.println(Math.max(2 * a[0], a[n - 1]));
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
    new A203().run();
  }
}
