package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Bingo {
  public void solve() throws IOException {
    int n = nextInt();
    for (int i = 0; i < n; i++) {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for (int x = 0; x < 25; x++) {
        if (x != 12) {
          map.put(nextInt(), x);
        }
      }

      boolean[][] board = new boolean[5][5];
      board[2][2] = true;

      int num = -1;
      for (int x = 0; x < 75; x++) {
        Integer index = map.get(nextInt());
        if (num == -1 && index != null) {
          board[index / 5][index % 5] = true;
          if (isBingo(board)) {
            num = x + 1;
          }
        }
      }
      System.out.format("BINGO after %d numbers announced\n", num);
    }
  }

  public boolean isBingo(boolean[][] board) {
    boolean ldiag = true;
    boolean rdiag = true;

    for (int x = 0; x < 5; x++) {
      boolean hwin = true;
      boolean vwin = true;
      for (int y = 0; y < 5; y++) {
        hwin = hwin && board[x][y];
        vwin = vwin && board[y][x];
      }
      if (hwin || vwin) {
        return true;
      }

      ldiag = ldiag && board[x][x];
      rdiag = rdiag && board[x][4 - x];
    }
    return ldiag || rdiag;
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
    new Bingo().run();
  }
}
