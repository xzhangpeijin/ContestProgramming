package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B218 {
  public void solve() throws IOException {
    int a = nextInt();
    int b = nextInt();
    State init = new State(a, b, 0);
    ArrayList<State> queue = new ArrayList<State>();
    queue.add(init);
    while (queue.size() > 0) {
      State cur = queue.remove(0);
      int max = Math.max(cur.a, cur.b);
      int min = Math.min(cur.a, cur.b);
      if (max == min) {
        System.out.println(cur.count);
        return;
      }
      if (max % 5 == 0)
        queue.add(new State(max / 5, min, cur.count + 1));
      if (max % 3 == 0)
        queue.add(new State(max / 3, min, cur.count + 1));
      if (max % 2 == 0)
        queue.add(new State(max / 2, min, cur.count + 1));
    }
    System.out.println(-1);
  }

  public class State {
    public int a, b, count;

    public State(int a, int b, int count) {
      this.a = a;
      this.b = b;
      this.count = count;
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
    new B218().run();
  }
}
