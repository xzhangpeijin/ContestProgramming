package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class A198 {
  public void solve() throws IOException {
    int size = nextInt();
    int[] locs = new int[size];
    for (int x = 0; x < size; x++)
      locs[x] = nextInt();

    long sum = 0;
    for (int x = 0; x < size - 1; x++)
      for (int y = x + 1; y < size; y++)
        sum += 2 * Math.abs(locs[x] - locs[y]);
    for (int x = 0; x < size; x++)
      sum += locs[x];

    int gcd = Integer.valueOf(new BigInteger(String.valueOf(sum)).gcd(
        new BigInteger(String.valueOf(size))).toString());

    sum /= gcd;

    out.println(sum + " " + size / gcd);
  }

  public int fact(int n) {
    if (n == 1)
      return 1;
    else
      return n * fact(n - 1);
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
    new A198().run();
  }
}
