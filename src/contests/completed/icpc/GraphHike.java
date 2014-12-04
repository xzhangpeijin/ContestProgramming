package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GraphHike {
  static class Position {
    public final int a, b, c;
    private final int moves;

    public Position(int a, int b, int c, int moves) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.moves = moves;
    }

    public char getColor(int p, char[][] graph) {
      switch (p) {
      case 0: return graph[b][c];
      case 1: return graph[a][c];
      case 2: return graph[a][b];
      }
      throw new IllegalArgumentException("Invalid piece");
    }

    public int getPos(int p) {
      switch (p) {
      case 0: return a;
      case 1: return b;
      case 2: return c;
      }
      throw new IllegalArgumentException("Invalid piece");
    }

    public Position newPosition(int p, int n) {
      switch (p) {
      case 0: return new Position(n, b, c, moves + 1);
      case 1: return new Position(a, n, c, moves + 1);
      case 2: return new Position(a, b, n, moves + 1);
      }
      throw new IllegalArgumentException("Invalid piece");
    }

    public boolean isFinal() {
      return a == b && b == c;
    }

    public int getMoves() {
      return moves;
    }
  }

  public void solve() throws IOException {
    int n;
    while ((n = nextInt()) != 0) {
      boolean[][][] hit = new boolean[n][n][n];
      Queue<Position> search = new LinkedList<Position>();

      Position start = new Position(nextInt() - 1, nextInt() - 1, nextInt() - 1, 0);
      search.add(start);
      hit[start.a][start.b][start.c] = true;

      char[][] graph = new char[n][n];
      for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++) {
          graph[x][y] = nextToken().charAt(0);
        }
      }

      if (start.isFinal()) {
        System.out.println(0);
      } else {
        search : {
          while (search.size() > 0) {
            Position cur = search.poll();
            for (int p = 0; p < 3; p++) {
              char color = cur.getColor(p, graph);
              for (int x = 0; x < n; x++) {
                if (graph[cur.getPos(p)][x] == color) {
                  Position pos = cur.newPosition(p, x);
                  if (pos.isFinal()) {
                    System.out.println(pos.getMoves());
                    break search;
                  }
                  if (!hit[pos.a][pos.b][pos.c]) {
                    search.add(pos);
                    hit[pos.a][pos.b][pos.c] = true;
                  }
                }
              }
            }
          }
          System.out.println("impossible");
        }
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
    new GraphHike().run();
  }
}
