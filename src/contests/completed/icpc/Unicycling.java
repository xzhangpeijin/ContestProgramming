package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Unicycling {
  class State {
    public final int moves;
    public final int place;

    public State(int moves, int place, List<Integer> visited) {
      this.moves = moves;
      this.place = place;
    }
  }

  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();

    boolean[][] paths = new boolean[n][n];

    for (int x = 0; x < m; x++) {
      int start = nextInt();
      int end = nextInt();
      paths[start - 1][end - 1] = true;
      paths[end - 1][start - 1] = true;
    }

    Queue<State> bfs = new LinkedList<State>();
    List<Integer> visited = new ArrayList<Integer>(1);
    visited.add(0);
    bfs.add(new State(1, 0, visited));

    while (bfs.size() > 0) {

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
    new Unicycling().run();
  }
}
