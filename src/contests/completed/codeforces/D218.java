package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D218 {
  public void solve() throws IOException {
    int n = nextInt();
    int[] capacities = new int[n];
    int[] vessels = new int[n];
    int[] nextfree = new int[n];
    for (int x = 0; x < n; x++) {
      capacities[x] = nextInt();
      vessels[x] = 0;
      nextfree[x] = x;
    }
    int m = nextInt();
    for (int x = 0; x < m; x++) {
      int type = nextInt();
      if (type == 1) {
        int vessel = nextInt();
        int amount = nextInt();
        int next = nextfree[vessel - 1];
        if (next < vessels.length) {
          vessels[next] += amount;
          nextfree[next] = overflow(vessels, capacities, nextfree, nextfree[vessel - 1]);
        }
      }
      if (type == 2) {
        int vessel = nextInt();
        System.out.println(vessels[vessel - 1]);
      }
    }
  }

  public int overflow(int[] vessels, int[] capacities, int[] nextfree, int index) {
    if (index < vessels.length) {
      if (vessels[index] < capacities[index])
        return index;
      else {
        int overflow = vessels[index] - capacities[index];
        vessels[index] = capacities[index];
        if (index != vessels.length - 1) {
          vessels[index + 1] += overflow;
          return nextfree[index + 1] = overflow(vessels, capacities, nextfree, index + 1);
        } else
          return vessels.length;
      }
    }
    return vessels.length;
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
    new D218().run();
  }
}
