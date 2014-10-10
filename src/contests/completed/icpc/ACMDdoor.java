package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACMDdoor {
  public void solve() throws IOException {
    int dif = nextInt();
    int count = 0;
    int max = 0;
    char[] input = nextLine().toCharArray();
    for (int x = 0; x < input.length; x++) {
      // System.out.println(x + " " + input[x]);
      if (Math.abs(count) <= dif) {
        if (input[x] == 'M')
          count++;
        else
          count--;
      }
      if (Math.abs(count) > dif) {
        if (x < input.length - 1 && count > 0 && input[x + 1] == 'W') {
          count--;
          x++;
          max++;
        } else if (x < input.length - 1 && count < 0 && input[x + 1] == 'M') {
          count++;
          x++;
          max++;
        } else
          break;
      }
      max++;
    }
    System.out.println(max);
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
    new ACMDdoor().run();
  }
}
