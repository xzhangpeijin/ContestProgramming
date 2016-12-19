package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C386 {
  
  public void solve() throws IOException {
    int s = nextInt();
    int x1 = nextInt();
    int x2 = nextInt();
    int t1 = nextInt();
    int t2 = nextInt();
    int p = nextInt();
    int d = nextInt();
    
    int walktime = Math.abs(x1 - x2) * t2;
    
    int traintime;
    if (x1 < x2) {
      if (d == 1 && p > x1) {
        traintime = (s - p + s + x2) * t1;
      } else if (d == 1 && p <= x1) {
        traintime = (x2 - p) * t1;
      } else {
        traintime = (p + x2) * t1;
      }
    } else {
      if (d == -1 && p < x1) {
        traintime = (p + s + s - x2) * t1;
      } else if (d == -1 && p >= x1) {
        traintime = (p - x2) * t1;
      } else {
        traintime = (s - p + s - x2) * t1;
      }
    }
    
    System.out.println(Math.min(walktime, traintime));
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
    new C386().run();
  }
}
