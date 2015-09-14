package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B305 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int q = nextInt();
    boolean[][] grid = new boolean[n][m];
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        grid[x][y] = (nextInt() == 1);
      }
    }
    int[] maxes = new int[n];
    int max = 0;
    for (int x = 0; x < n; x++) {
      int count = 0;
      int rowmax = 0;
      for (int y = 0; y < m; y++) {
        if (grid[x][y]) {
          count++;
        } else {
          rowmax = Math.max(count, rowmax);
          count = 0;
        }
      }
      rowmax = Math.max(count, rowmax);
      maxes[x] = rowmax;
      max = Math.max(rowmax, max);
    }
    
    for (int x = 0; x < q; x++) {
      int row = nextInt() - 1;
      int col = nextInt() - 1;
      grid[row][col] = !grid[row][col];
      
      int count = 0;
      int rowmax = 0;
      for (int y = 0; y < m; y++) {
        if (grid[row][y]) {
          count++;
        } else {
          rowmax = Math.max(count, rowmax);
          count = 0;
        }
      }
      rowmax = Math.max(count, rowmax);
      
      if (rowmax != maxes[row]) {
        maxes[row] = rowmax;
        max = 0;
        for (int y = 0; y < n; y++) {
          max = Math.max(max, maxes[y]);
        }
      }
      System.out.println(max);
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
    new B305().run();
  }
}
