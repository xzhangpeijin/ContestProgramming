package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A202 {
  public void solve() throws IOException {
    int n = nextInt();
    int[] cur = new int[2];

    boolean cando = true;
    for (int x = 0; x < n; x++) {
      int a = nextInt();
      if (a == 25)
        cur[0]++;
      else if (a == 50) {
        cur[1]++;
        cur[0]--;
      } else if (a == 100) {
        cur[0]--;
        if (cur[1] > 0)
          cur[1]--;
        else
          cur[0] -= 2;
      }
      if (cur[0] < 0) {
        cando = false;
        break;
      }
    }

    if (cando)
      out.println("YES");
    else
      out.println("NO");

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
    new A202().run();
  }
}
