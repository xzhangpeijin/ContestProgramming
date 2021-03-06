package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A254 {
  public void solve() throws IOException {
    int l = nextInt();
    int w = nextInt();
    char[][] input = new char[l][w];
    for (int x = 0; x < l; x++)
      input[x] = nextLine().toCharArray();
    char[][] ans = new char[l][w];

    for (int x = 0; x < l; x++) {
      for (int y = 0; y < w; y++) {
        if (input[x][y] == '-')
          ans[x][y] = '-';
        else {
          char up = '-', left = '-';
          if (x != 0)
            up = ans[x - 1][y];
          if (y != 0)
            left = ans[x][y - 1];
          if (up == '-')
            up = left;
          if (up == 'B')
            ans[x][y] = 'W';
          else
            ans[x][y] = 'B';
        }
        System.out.print(ans[x][y]);
      }
      System.out.println();
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
    new A254().run();
  }
}
