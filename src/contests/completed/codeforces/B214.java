package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B214 {
  public void solve() throws IOException {
    int n = nextInt();
    int k = nextInt();
    int[] pow = new int[n];
    for (int x = 0; x < n; x++)
      pow[x] = nextInt();

    int minpow = Integer.MAX_VALUE;
    int minindex = -1;
    for (int x = 0; x < k; x++) {
      int total = 0;
      for (int y = 0; y < n / k; y++) {
        int index = (x + y * k) % n;
        total += pow[index];
      }
      if (total < minpow) {
        minpow = total;
        minindex = x;
      }
      // System.out.println(x + " " + total);
    }
    System.out.println(minindex + 1);

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
    new B214().run();
  }
}
