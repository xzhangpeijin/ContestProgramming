package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class KeyTask
{	
  public static final char LEFT = 'L';
  public static final char RIGHT = 'R';
  public static final char UP = 'U';
  public static final char DOWN = 'D';
  public static final char[] DIRS = {LEFT, RIGHT, UP, DOWN};

  class State {
    public boolean blue = false;
    public boolean yellow = false;
    public boolean red = false;
    public boolean green = false;
    public final int row;
    public final int col;
    public final int moves;

    public State(int row, int col) {
      this.row = row;
      this.col = col;
      this.moves = 0;
    }

    public State(State state, char dir) {
      switch (dir) {
      case LEFT: this.row = state.row; this.col = state.col - 1; break;
      case RIGHT: this.row = state.row; this.col = state.col + 1; break;
      case UP: this.row = state.row - 1; this.col = state.col; break;
      case DOWN: this.row = state.row + 1; this.col = state.col; break;
      default: throw new RuntimeException("Invalid Direction");
      }
      this.blue = state.blue;
      this.yellow = state.yellow;
      this.red = state.red;
      this.green = state.green;
      this.moves = state.moves + 1;
    }

    public String hashString() {
      return blue + ":" + yellow + ":" + red + ":" + green + ":" + row + ":" + col;
    }
  }

  public boolean canMove(State state, char dir, char[][] map) {
    if ((state.row == 0 && dir == UP) || 
        (state.row == map.length - 1 && dir == DOWN) || 
        (state.col == 0 && dir == LEFT) || 
        (state.col == map[0].length - 1 && dir == RIGHT)) {
      return false;
    }
    int row = state.row;
    int col = state.col;
    switch (dir) {
    case LEFT: col--; break;
    case RIGHT: col++; break;
    case UP: row--; break;
    case DOWN: row++; break;
    default: throw new RuntimeException("Invalid direction");
    }
    char block = map[row][col];
    if (block == '#') {
      return false;
    } else if (block == '.') {
      return true;
    } else if (block == 'G') {
      return state.green;
    } else if (block == 'R') {
      return state.red;
    } else if (block == 'B') {
      return state.blue;
    } else if (block == 'Y') {
      return state.yellow;
    } else {
      return true;
    }
  }

  public State makeMove(State state, char dir, char[][] map) {
    State newState = new State(state, dir);
    char block = map[newState.row][newState.col];
    switch (block) {
    case 'b': newState.blue = true; break;
    case 'y': newState.yellow = true; break;
    case 'r': newState.red = true; break;
    case 'g': newState.green = true; break;
    }
    return newState;
  }

  public void solve() throws IOException 
  {
    int rows, cols;
    while ((rows = nextInt()) != 0 && (cols = nextInt()) != 0) {
      char[][] map = new char[rows][cols];
      int startRow = -1, startCol = -1;
      for (int x = 0; x < rows; x++) {
        String nextline = nextLine();
        for (int y = 0; y < nextline.length(); y++) {
          map[x][y] = nextline.charAt(y);
          if (map[x][y] == '*') {
            startRow = x;
            startCol = y;
          }
        }
      }

      if (startRow == -1 || startCol == -1) {
        throw new RuntimeException("No start position");
      }

      State start = new State(startRow, startCol);

      HashMap<String, Integer> dp = new HashMap<String, Integer>();
      dp.put(start.hashString(), start.moves);

      Queue<State> bfs = new LinkedList<State>();
      bfs.add(start);

      boolean escape = false;
      search: {
        while(bfs.size() > 0) {
          State cur = bfs.poll();
          Integer moves = dp.get(cur.hashString());
          if (moves != null && moves == cur.moves) { 
            for (char dir : DIRS) {
              if (canMove(cur, dir, map)) {
                State state = makeMove(cur, dir, map);
                if (map[state.row][state.col] == 'X') {
                  System.out.format("Escape possible in %d steps.\n", state.moves);
                  escape = true;
                  break search;
                }
                Integer newMoves = dp.get(state.hashString());
                if (newMoves == null || state.moves < newMoves) {
                  dp.put(state.hashString(), state.moves);
                  bfs.add(state);
                }
              }
            }
          }
        }
      }
      if (!escape) {
        System.out.println("The poor student is trapped!");
      }
    }


  }

  public BufferedReader br;
  public StringTokenizer st;
  public PrintWriter out;

  public String nextToken() throws IOException {
    while(st == null || !st.hasMoreTokens()) {
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

  public long nextLong() throws  IOException {
    return Long.parseLong(nextToken());
  }

  public double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  public void run() throws IOException 
  {	
    boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    oj = true;
    br = new BufferedReader( new InputStreamReader( oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter( oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException 
  {
    new KeyTask().run();
  }
}
