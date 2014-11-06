package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TrainPassengers {
  
  public void solve() throws IOException {
    long C = nextLong();
    int n = nextInt();
    int size = 0;
    boolean possible = true;
    for (int x = 0; x < n; x++) {
      long off = nextLong();
      long enter = nextLong();
      long wait = nextLong();
      
      size -= off;
      if (size < 0) {
        possible = false;
      }
      
      size += enter;
      if (size > C) {
        possible = false;
      }
      
      if ((size != C || x == n - 1) && wait > 0) {
        possible = false;
      }
    }
    if (size != 0) {
      possible = false;
    }
    if (possible) {
      System.out.println("possible");
    } else {
      System.out.println("impossible");
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
    new TrainPassengers().run();
  }
}
