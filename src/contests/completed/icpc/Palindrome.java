package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Palindrome {
  public int[][] needref;

  public void solve() throws IOException {
    int n = nextInt();
    String input = nextToken();
    needref = new int[n][n];
    for (int x = 0; x < n; x++)
      for (int y = x + 1; y < n; y++)
        needref[x][y] = -1;
    int min = n;
    for (int x = 0; x < n - 1; x++) {
      int beg = x - 1;
      int end = x + 1;
      // System.out.println(x + " " + needed(input, beg, end) + " " +
      // needed(input, beg + 1, end));
      min = Math.min(min, needed(input, beg, end));
      if (input.charAt(x) == input.charAt(x + 1))
        min = Math.min(min, needed(input, beg + 1, end));
    }
    System.out.println(min);
  }

  public int needed(String a, int start, int end) {
    if (start < 0)
      return a.length() - end;
    if (end >= a.length())
      return start + 1;

    if (needref[start][end] != -1)
      return needref[start][end];

    if (a.charAt(start) != a.charAt(end)) {
      return needref[start][end] = (1 + Math.min(needed(a, start - 1, end),
          needed(a, start, end + 1)));
    } else
      return needref[start][end] = needed(a, start - 1, end + 1);
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
    new Palindrome().run();
  }
}
