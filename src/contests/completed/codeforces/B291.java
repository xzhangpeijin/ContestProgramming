package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B291 {
  
  static class Point {
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int xoff = nextInt();
    int yoff = nextInt();
    
    boolean[] hit = new boolean[n];
    Point[] targets = new Point[n];
    
    for (int x = 0; x < n; x++) {
      targets[x] = new Point(nextInt() - xoff, nextInt() - yoff);
    }
    
    int shots = 0;
    for (int x = 0; x < n; x++) {
      if (!hit[x]) {
        Point a = targets[x];
        for (int y = x; y < n; y++) {
          Point b = targets[y];
          if (a.x * b.y == b.x * a.y) {
            hit[y] = true;
          }
        }
        
        shots++;
      }
    }
    System.out.println(shots);
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
    new B291().run();
  }
}
