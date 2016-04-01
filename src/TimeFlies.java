

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TimeFlies {
  static enum Dir {
    UP, DOWN, LEFT, RIGHT
  }
  
  static class Node implements Comparable<Node> {
    public int x, y, f;
    public List<Dir> path;
    
    public Node(int x, int y, int h, List<Dir> path) {
     this.x = x;
     this.y = y;
     this.f = h + path.size();
     this.path = path;      
    }  
    
    @Override
    public int compareTo(Node a) {
      return this.f - a.f;
    }
  }
  
  static boolean canEnter(char[][] board, int x, int y, boolean dressed) {
    switch (board[x][y]) {
    case '-':
    case '+':
    case '=':
    case '|':
      return false;
    case 'x':
      return dressed;
    default:
      return true;
    }
  }
  
  static class Position {
    int x, y;
    public Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  static Position getPosition(char[][] board, char target) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == target) {
          return new Position(i, j);
        }
      }
    }
    return null;
  }
  
  static int getHeuristic(int x, int y, Position target) {
    return Math.abs(x - target.x) + Math.abs(y - target.y);
  }
  
  static List<Dir> aStar(char[][] board, Position start, Position target, boolean dressed) {
    Node init = new Node(start.x, start.y, 
        getHeuristic(start.x, start.y, target), new ArrayList<Dir>());
    PriorityQueue<Node> queue = new PriorityQueue<Node>();
    queue.add(init);
    while (queue.size() > 0) {
      Node state = queue.poll();
      if (state.x == target.x && state.y == target.y) {
        return state.path;
      }
      if (canEnter(board, state.x + 1, state.y, dressed)) {
        List<Dir> copy = new ArrayList<Dir>(state.path);
        copy.add(Dir.DOWN);
        queue.add(new Node(state.x + 1, state.y, 
            getHeuristic(state.x + 1, state.y, target), copy));
      }
      if (canEnter(board, state.x - 1, state.y, dressed)) {
        List<Dir> copy = new ArrayList<Dir>(state.path);
        copy.add(Dir.UP);
        queue.add(new Node(state.x - 1, state.y, 
            getHeuristic(state.x - 1, state.y, target), copy));
      }
      if (canEnter(board, state.x, state.y + 1, dressed)) {
        List<Dir> copy = new ArrayList<Dir>(state.path);
        copy.add(Dir.RIGHT);
        queue.add(new Node(state.x, state.y + 1, 
            getHeuristic(state.x, state.y + 1, target), copy));
      }
      if (canEnter(board, state.x, state.y - 1, dressed)) {
        List<Dir> copy = new ArrayList<Dir>(state.path);
        copy.add(Dir.LEFT);
        queue.add(new Node(state.x, state.y - 1, 
            getHeuristic(state.x, state.y - 1, target), copy));
      }
    }
    return null;
  }
  
  public void solve() throws IOException {
    char[][] board = new char[10][];
    for (int i = 0; i < 10; i++) {
      board[i] = nextLine().toCharArray();
    }
    
    List<Dir> path = new ArrayList<Dir>();
    
    Position start = getPosition(board, 's');
    for (int i = 0; i < 5; i++) {
      Position target = getPosition(board, (char)('1' + i));
      path.addAll(aStar(board, start, target, false));
      start = target;
    }
    path.addAll(aStar(board, start, getPosition(board, 'x'), true));
    
    for (Dir dir : path) {
      char output = ' ';
      switch (dir) {
      case LEFT: output = 'l'; break;
      case RIGHT: output = 'r'; break;
      case UP: output = 'u'; break;
      case DOWN: output = 'd'; break;
      }
      System.out.println(output);
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
    new TimeFlies().run();
  }
}
