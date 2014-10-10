package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Vive {
  public void solve() throws IOException {
    while (true) {
      int[] num = new int[4];
      for (int x = 0; x < 4; x++)
        num[x] = nextInt();
      if (num[0] == 0 && num[1] == 0 && num[2] == 0 && num[3] == 0)
        break;

      int steps = 0;
      while (!(num[0] == num[1] && num[0] == num[2] && num[0] == num[3])) {
        int temp = num[0];
        num[0] = Math.abs(num[0] - num[1]);
        num[1] = Math.abs(num[1] - num[2]);
        num[2] = Math.abs(num[2] - num[3]);
        num[3] = Math.abs(num[3] - temp);
        steps++;
      }
      System.out.println(steps);
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
    new Vive().run();
  }
}
