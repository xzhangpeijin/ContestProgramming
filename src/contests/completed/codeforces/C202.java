package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C202 {
  public void solve() throws IOException {
    int n = nextInt();
    int[] a = new int[n];
    for (int x = 0; x < n; x++)
      a[x] = nextInt();
    Arrays.sort(a);
    int rounds = 0;
    while (a[n - 1] > 0) {
      if (a[0] == 0) {
        rounds += a[n - 1];
        break;
      }
      int diff = a[1] - a[0] + 1;
      for (int x = 1; x < n; x++)
        a[x] -= diff;
      Arrays.sort(a);
      rounds += diff;
    }

    System.out.println(rounds);
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
    new C202().run();
  }
}
