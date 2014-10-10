package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C266 {
  public void solve() throws IOException {
    int n = nextInt();
    int[] a = new int[n];
    long total = 0;
    for (int x = 0; x < n; x++) {
      a[x] = nextInt();
      total += a[x];
    }

    if (total % 3 != 0) {
      System.out.println(0);
      return;
    }

    long third = total / 3;
    long twothird = 2 * third;

    long first = 0;
    long tot = 0;

    long[] partials = new long[n];
    for (int x = 0; x < n - 1; x++) {
      if (x == 0) {
        partials[x] = a[x];
      } else {
        partials[x] = partials[x - 1] + a[x];
      }

      if (partials[x] == twothird) {
        tot += first;
      }
      if (partials[x] == third) {
        first++;
      }
      // System.out.println(partials[x] + " " + first.size() + " " +
      // second.size());
    }
    System.out.println(tot);
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
    new C266().run();
  }
}
