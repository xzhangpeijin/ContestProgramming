package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B277 {
  
  public void solve() throws IOException {
    int m = nextInt();
    int n = nextInt();
    boolean[][] A = new boolean[m][n];
    boolean[][] B = new boolean[m][n];
    
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        B[x][y] = (nextInt() == 1);
        A[x][y] = true;
      }
    }
    
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (!B[x][y]) {
          for (int z = 0; z < m; z++) {
            A[z][y] = false;
          }
          for (int z = 0; z < n; z++) {
            A[x][z] = false;
          }
        }
      }
    }
    
    boolean possible = true;
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (B[x][y]) {
          boolean satisfied = false;
          for (int z = 0; z < m; z++) {
            satisfied |= A[z][y];
          }
          for (int z = 0; z < n; z++) {
            satisfied |= A[x][z];
          }
          if (!satisfied) {
            possible = false;
          }
        }
      }
    }
    if (possible) {
      System.out.println("YES");
      for (int x = 0; x < m; x++) {
        StringBuffer buf = new StringBuffer();
        for (int y = 0; y < n; y++) {
          buf.append(A[x][y] ? "1 " : "0 ");
        }
        System.out.println(buf.toString().trim());
      }
    } else {
      System.out.println("NO");
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
    new B277().run();
  }
}
