package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HouseCleaning {
  public static final char LEFT = 'L';
  public static final char RIGHT = 'R';
  public static final char UP = 'U';
  public static final char DOWN = 'D';
  public static final char[] DIRS = { LEFT, RIGHT, UP, DOWN };

  public void solve() throws IOException {
    int cols = nextInt();
    int rows = nextInt();
    int[][] heights = new int[rows][cols];
    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < cols; y++) {
        heights[x][y] = nextInt();
      }
    }
    boolean[][] filled = new boolean[rows][cols];
    filled[0][0] = true;

    int numfill = 1;
    int energy = 0;
    while (numfill != rows * cols) {
      int moverow = -1;
      int movecol = -1;
      int min = Integer.MAX_VALUE;
      int minpart = Integer.MAX_VALUE;
      for (int x = 0; x < rows; x++) {
        for (int y = 0; y < cols; y++) {
          if (filled[x][y]) {
            for (char dir : DIRS) {
              if ((x == 0 && dir == UP) || (x == rows - 1 && dir == DOWN)
                  || (y == 0 && dir == LEFT) || (y == cols - 1 && dir == RIGHT)) {
                continue;
              }
              int row = x;
              int col = y;
              switch (dir) {
              case LEFT:
                col--;
                break;
              case RIGHT:
                col++;
                break;
              case UP:
                row--;
                break;
              case DOWN:
                row++;
                break;
              default:
                throw new RuntimeException("Invalid direction");
              }
              if (!filled[row][col]) {
                int curmin = Math.min(heights[x][y], heights[row][col]);
                int curpart = Math.max(heights[x][y], heights[row][col]);
                if (curmin < min) {
                  min = curmin;
                  minpart = curpart;
                  moverow = row;
                  movecol = col;
                } else if (curmin == min && curpart < minpart) {
                  minpart = curpart;
                  moverow = row;
                  movecol = col;
                }
              }
            }
          }
        }
      }
      filled[moverow][movecol] = true;
      energy += min;
      numfill++;
    }
    System.out.println(energy);
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
    new HouseCleaning().run();
  }
}
