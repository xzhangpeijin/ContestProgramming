package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B261 {
  public void solve() throws IOException {
    int n = nextInt();
    long min = Integer.MAX_VALUE;
    long mincount = 0;
    long max = Integer.MIN_VALUE;
    long maxcount = 0;
    for (int x = 0; x < n; x++) {
      int num = nextInt();

      if (num == min) {
        mincount++;
      } else if (num < min) {
        min = num;
        mincount = 1;
      }

      if (num == max) {
        maxcount++;
      } else if (num > max) {
        max = num;
        maxcount = 1;
      }
    }

    if (min == max) {
      System.out.println("0 " + (mincount * (maxcount - 1) / 2));
    } else {
      System.out.println((max - min) + " " + (mincount * maxcount));
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
    new B261().run();
  }
}
