package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACMTryoutE {
  public void solve() throws IOException {
    while (true) {
      int r = nextInt();
      int c = nextInt();
      if (r == 0 && c == 0)
        break;

      int[][] arr = new int[r][c];
      for (int x = 0; x < r; x++) {
        char[] input = nextToken().toCharArray();
        for (int y = 0; y < c; y++)
          arr[x][y] = (input[y] == '.') ? 0 : 9;
      }

      for (int x = 0; x < r; x++) {
        for (int y = 0; y < c; y++) {
          if (arr[x][y] > 8) {
            if (x != r - 1) {
              if (y != c - 1)
                arr[x + 1][y + 1]++;
              if (y != 0)
                arr[x + 1][y - 1]++;
              arr[x + 1][y]++;
            }
            if (x != 0) {
              if (y != c - 1)
                arr[x - 1][y + 1]++;
              if (y != 0)
                arr[x - 1][y - 1]++;
              arr[x - 1][y]++;
            }
            if (y != c - 1)
              arr[x][y + 1]++;
            if (y != 0)
              arr[x][y - 1]++;
          }
        }
      }

      for (int x = 0; x < r; x++) {
        for (int y = 0; y < c; y++) {
          if (arr[x][y] > 8)
            System.out.print("*");
          else
            System.out.print(arr[x][y]);
        }
        System.out.println();
      }
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
    new ACMTryoutE().run();
  }
}
