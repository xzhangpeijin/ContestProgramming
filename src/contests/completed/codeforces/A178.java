package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A178 {
  public void solve() throws IOException {
    int n = nextInt();
    int[] a = new int[n];
    for (int x = 0; x < n; x++)
      a[x] = nextInt();
    int m = nextInt();
    for (int x = 0; x < m; x++) {
      int wire = nextInt() - 1;
      int bird = nextInt();
      shoot(a, wire, bird);
    }
    for (int x = 0; x < n; x++) {
      System.out.println(a[x]);
    }
  }

  public void shoot(int[] a, int x, int y) {
    int birds = a[x];
    int right = birds - y;
    int left = y - 1;
    a[x] = 0;

    if (x != 0) {
      a[x - 1] += left;
    }
    if (x != a.length - 1) {
      a[x + 1] += right;
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
    new A178().run();
  }
}
