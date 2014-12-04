package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Raisins {
  
  public int[][][][] minpayments;
  public int[][][][] numraisins;

  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int[][] raisins = new int[n][m];
    int[][] memo = new int[n][m];
    for (int x = 0; x < n; x++) {
      int total = 0;
      for (int y = 0; y < m; y++) {
        raisins[x][y] = nextInt();
        total += raisins[x][y];
        if (x == 0) {
          memo[x][y] = total;
        } else {
          memo[x][y] = memo[x - 1][y] + total;
        }
      }
    }
    
    minpayments = new int[n][m][n][m];
    numraisins = new int[n][m][n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = i; k < n; k++) {
          for (int l = j; l < m; l++) {
            minpayments[i][j][k][l] = -1;
            numraisins[i][j][k][l] = memo[k][l];
            if (i > 0) {
              numraisins[i][j][k][l] -= memo[i - 1][l];
            }
            if (j > 0) {
              numraisins[i][j][k][l] -= memo[k][j - 1];
            }
            if (i > 0 && j > 0) {
              numraisins[i][j][k][l] += memo[i - 1][j - 1];
            }
          }
        }
      }
    }
    
    System.out.println(getPayments(0, 0, n - 1, m - 1));
  }
  
  public int getPayments(int i, int j, int k, int l) {
    if (minpayments[i][j][k][l] == -1) {
      if (i == k && j == l) {
        minpayments[i][j][k][l] = 0;
      } else {
        int min = Integer.MAX_VALUE;
        
        for (int row = i; row < k; row++) {
          min = Math.min(min, getPayments(i, j, row, l) + getPayments(row + 1, j, k, l));
        }
        
        for (int col = j; col < l; col++) {
          min = Math.min(min, getPayments(i, j, k, col) + getPayments(i, col + 1, k, l));
        }
        
        minpayments[i][j][k][l] = numraisins[i][j][k][l] + min;
      }
    }
    return minpayments[i][j][k][l];
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
    new Raisins().run();
  }
}
