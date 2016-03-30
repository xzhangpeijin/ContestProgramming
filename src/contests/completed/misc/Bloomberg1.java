package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bloomberg1 {
  private static class State {
    int x, y, length;
    public State(int x, int y, int length) {
      this.x = x;
      this.y = y;
      this.length = length;
    }
  }
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    int startx = nextInt();
    int starty = nextInt();
    
    int[][] input = new int[n][m];
    int[][] dp = new int[n][m];
    
    for (int x = 0; x < n; x ++) {
      for (int y = 0; y < m; y++) {
        input[x][y] = nextInt();
      }
    }
    
    int max = 0;
    State init = new State(startx, starty, 0);
    Queue<State> search = new LinkedList<State>();
    search.add(init);
    while (search.size() > 0) {
      State cur = search.poll();
      if (cur.length != dp[cur.x][cur.y]) {
        continue;
      }
      max = Math.max(max, cur.length);
      if (cur.x > 0 && 
          input[cur.x][cur.y] > input[cur.x - 1][cur.y] &&
          dp[cur.x - 1][cur.y] < cur.length + 1) {
        dp[cur.x - 1][cur.y] = cur.length + 1;
        search.add(new State(cur.x - 1, cur.y, cur.length + 1));
      }
      if (cur.y > 0 && 
          input[cur.x][cur.y] > input[cur.x][cur.y - 1] &&
          dp[cur.x][cur.y - 1] < cur.length + 1) {
        dp[cur.x][cur.y - 1] = cur.length + 1;
        search.add(new State(cur.x, cur.y - 1, cur.length + 1));
      }
      if (cur.x < n - 1 && 
          input[cur.x][cur.y] > input[cur.x + 1][cur.y] &&
          dp[cur.x + 1][cur.y] < cur.length + 1) {
        dp[cur.x + 1][cur.y] = cur.length + 1;
        search.add(new State(cur.x + 1, cur.y, cur.length + 1));
      }
      if (cur.y < m - 1 && 
          input[cur.x][cur.y] > input[cur.x][cur.y + 1] &&
          dp[cur.x][cur.y + 1] < cur.length + 1) {
        dp[cur.x][cur.y + 1] = cur.length + 1;
        search.add(new State(cur.x, cur.y + 1, cur.length + 1));
      }
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
    new Bloomberg1().run();
  }
}
