package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A220 {
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int i = nextInt();
    int j = nextInt();
    int a = nextInt();
    int b = nextInt();

    int[] min = new int[4];
    for (int x = 0; x < 4; x++)
      min[x] = 1000000;

    int[][] co = { { 1, m }, { n, 1 }, { n, m }, { 1, 1 } };
    for (int x = 0; x < co.length; x++) {
      int xdiff = co[x][0] - i;
      int ydiff = co[x][1] - j;
      if (xdiff % a == 0 && ydiff % b == 0) {
        int xmov = Math.abs(xdiff / a);
        int ymov = Math.abs(ydiff / b);
        // System.out.println(xmov + " " + ymov);
        if (Math.abs(xmov - ymov) % 2 == 0)
          min[x] = Math.max(xmov, ymov);
      }
      // System.out.println(min[x]);
    }

    int moves = 1000000;
    for (int x = 0; x < 4; x++)
      moves = Math.min(moves, min[x]);
    if (moves == 1000000)
      System.out.println("Poor Inna and pony!");
    else
      System.out.println(moves);

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
    new A220().run();
  }
}
