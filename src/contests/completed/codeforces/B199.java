package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B199 {
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int s = nextInt();
    int f = nextInt();

    ArrayList<int[]> watch = new ArrayList<int[]>();
    for (int x = 0; x < m; x++) {
      int[] temp = new int[3];
      temp[0] = nextInt();
      temp[1] = nextInt();
      temp[2] = nextInt();
      watch.add(temp);
    }

    int cur = s;
    char dir = (s > f) ? 'L' : 'R';
    char[] ans = new char[n + m];
    int[] nextwatch = watch.remove(0);
    int time = 1;
    while (cur != f) {
      if (nextwatch[0] == time) {
        if (dir == 'L')
          nextwatch[2]++;
        else
          nextwatch[1]--;
        if (cur >= nextwatch[1] && cur <= nextwatch[2])
          ans[time - 1] = 'X';
        else
          ans[time - 1] = dir;
        nextwatch = watch.remove(0);
      } else
        ans[time - 1] = dir;

      if (ans[time - 1] == 'L')
        cur--;
      else if (ans[time - 1] == 'R')
        cur++;

      time++;
    }
    System.out.println(new String(ans).trim());
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
    new B199().run();
  }
}
