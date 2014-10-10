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

public class Presidential {
  class Board {
    public final boolean[][] board;
    public final int queens;
    public final int index;

    public Board(boolean[][] board, int queens, int index) {
      this.board = board;
      this.queens = queens;
      this.index = index;
    }
  }

  public void solve() throws IOException {
    int w = nextInt();
    int h = nextInt();
    int n = nextInt();

    if (n > Math.min(w, h)) {
      System.out.println(0);
      return;
    }

    Queue<Board> search = new LinkedList<Board>();
    boolean[][] base = new boolean[w][h];
    search.add(new Board(base, 0, 0));

    int count = 0;
    while (search.size() > 0) {
      Board board = search.poll();

      for (int x = 0; x < h; x++) {
        if (isValid(board.board, board.index, x)) {
          int newqueens = board.queens + 1;
          if (newqueens == n) {
            count++;
          } else {
            int newindex = board.index + 1;
            if (newindex >= w) {
              break;
            }
            boolean[][] newboard = new boolean[w][];
            for (int y = 0; y < w; y++) {
              newboard[y] = board.board[y].clone();
            }
            newboard[board.index][x] = true;
            search.add(new Board(newboard, newqueens, newindex));
          }
        }
      }

      if (board.queens + w - board.index > n) {
        boolean[][] newboard = new boolean[w][];
        for (int y = 0; y < w; y++) {
          newboard[y] = board.board[y].clone();
        }
        int newindex = board.index + 1;
        if (newindex >= w) {
          break;
        }
        search.add(new Board(newboard, board.queens, newindex));
      }
    }
    System.out.println(count);
  }

  public boolean isValid(boolean[][] board, int w, int h) {
    for (int x = 0; x < board.length; x++) {
      if (board[x][h]) {
        return false;
      }
    }

    for (int x = 0; x < board[0].length; x++) {
      if (board[w][x]) {
        return false;
      }
    }

    for (int x = 0; x < 8; x++) {
      int modw = w + x;
      int modh = h + x;

      if (modw < board.length && modh < board[0].length) {
        if (board[modw][modh]) {
          return false;
        }
      } else {
        break;
      }
    }

    for (int x = 0; x < 8; x++) {
      int modw = w - x;
      int modh = h - x;

      if (modw >= 0 && modh >= 0) {
        if (board[modw][modh]) {
          return false;
        }
      } else {
        break;
      }
    }

    for (int x = 0; x < 8; x++) {
      int modw = w - x;
      int modh = h + x;

      if (modw >= 0 && modh < board[0].length) {
        if (board[modw][modh]) {
          return false;
        }
      } else {
        break;
      }
    }

    for (int x = 0; x < 8; x++) {
      int modw = w + x;
      int modh = h - x;

      if (modw < board.length && modh >= 0) {
        if (board[modw][modh]) {
          return false;
        }
      } else {
        break;
      }
    }

    return true;
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
    new Presidential().run();
  }
}
