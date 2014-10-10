package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A269 {
  public void solve() throws IOException {
    int[] counts = new int[10];
    for (int x = 0; x < 6; x++) {
      counts[nextInt()]++;
    }

    boolean hasfour = false;
    for (int x = 1; x < 10; x++) {
      if (counts[x] >= 4) {
        hasfour = true;
        counts[x] -= 4;
        break;
      }
    }

    if (!hasfour) {
      System.out.println("Alien");
      return;
    }

    for (int x = 1; x < 10; x++) {
      if (counts[x] == 1) {
        System.out.println("Bear");
        return;
      }
      if (counts[x] == 2) {
        System.out.println("Elephant");
        return;
      }
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
    new A269().run();
  }
}
