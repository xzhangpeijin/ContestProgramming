package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A205 {
  public void solve() throws IOException {
    int n = nextInt();
    int eo = 0;
    int sum1 = 0;
    int sum2 = 0;
    for (int x = 0; x < n; x++) {
      int a = nextInt();
      int b = nextInt();
      sum1 += a;
      sum2 += b;
      if (a % 2 != b % 2)
        eo++;
    }
    sum1 %= 2;
    sum2 %= 2;
    if (sum1 == 0 && sum2 == 0)
      System.out.println(0);
    else if (sum1 == 1 && sum2 == 1) {
      if (eo >= 1 && n > 1)
        System.out.println(1);
      else
        System.out.println(-1);
    } else {
      System.out.println(-1);
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
    new A205().run();
  }
}
