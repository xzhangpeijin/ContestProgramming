package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B178 {

  public void solve() throws IOException {
    int n = nextInt();

    ArrayList<Integer> one = new ArrayList<Integer>();
    ArrayList<Integer> two = new ArrayList<Integer>();

    for (int x = 0; x < n; x++) {
      int thick = nextInt();
      int width = nextInt();
      if (thick == 1) {
        one.add(width);
      } else {
        two.add(width);
      }
    }

    Collections.sort(one);
    Collections.sort(two);

    int minthick = Integer.MAX_VALUE;
    for (int x = one.size() - 1; x >= -1; x--) {
      for (int y = two.size() - 1; y >= -1; y--) {
        int ones = one.size() - 1 - x;
        int twos = two.size() - 1 - y;
        int thickness = ones + 2 * twos;

        int width = 0;
        for (int i = x; i >= 0; i--) {
          width += one.get(i);
        }
        for (int i = y; i >= 0; i--) {
          width += two.get(i);
        }

        if (width <= thickness) {
          minthick = Math.min(thickness, minthick);
        }
      }
    }

    System.out.println(minthick);

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
    new B178().run();
  }
}
