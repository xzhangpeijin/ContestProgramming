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

public class Bloomberg2 {
  private static enum Direction {
    UP, DOWN, LEFT, RIGHT;
  }
  
  private static class State {
    int x, y, length, delta;
    Direction dir;
    public State(int x, int y, int length, int delta, Direction dir) {
      this.x = x;
      this.y = y;
      this.length = length;
      this.delta = delta;
      this.dir = dir;
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
    Queue<State> search = new LinkedList<State>();
    
    if (startx > 0 && input[startx][starty] >= input[startx - 1][starty]) {
      int fall = input[startx][starty] - input[startx - 1][starty];
      search.add(new State(
          startx - 1, starty, 1, fall, Direction.UP));
      dp[startx - 1][starty] = 1;
    }
    
    if (starty > 0 && input[startx][starty] >= input[startx][starty - 1]) {
      int fall = input[startx][starty] - input[startx][starty - 1];
      search.add(new State(
          startx, starty - 1, 1, fall, Direction.LEFT));
      dp[startx][starty - 1] = 1;
    }
    
    if (startx < n - 1 && input[startx][starty] >= input[startx + 1][starty]) {
      int fall = input[startx][starty] - input[startx + 1][starty];
      search.add(new State(
          startx + 1, starty, 1, fall, Direction.DOWN));
      dp[startx + 1][starty] = 1;
    }
    
    if (starty < m - 1 && input[startx][starty] >= input[startx][starty + 1]) {
      int fall = input[startx][starty] - input[startx - 1][starty];
      search.add(new State(
          startx, starty + 1, 1, fall, Direction.RIGHT));
      dp[startx][starty + 1] = 1;
    }
    
    while (search.size() > 0) {
      State cur = search.poll();
      if (cur.length != dp[cur.x][cur.y]) {
        continue;
      }
      //System.out.println(cur.x + " " + cur.y + " " + cur.length);
      max = Math.max(max, cur.length);
      int reach = cur.delta / 5;
      
      if (cur.x > 0 && cur.dir != Direction.DOWN && 
          input[cur.x][cur.y] + reach >= input[cur.x - 1][cur.y]) {
        if (dp[cur.x - 1][cur.y] < cur.length + 1) {
          int newdelta = cur.delta;
          if (input[cur.x][cur.y] > input[cur.x - 1][cur.y]) {
            newdelta = Math.min(50, newdelta + input[cur.x][cur.y] - input[cur.x - 1][cur.y]);
          } else {
            newdelta = newdelta - (input[cur.x - 1][cur.y] - input[cur.x][cur.y]) * 5;
          }
          dp[cur.x - 1][cur.y] = cur.length + 1;
          search.add(new State(cur.x - 1, cur.y, cur.length + 1, newdelta, Direction.UP));
        }
      }
      
      if (cur.y > 0) {
        //System.out.println(cur.x + " "+ cur.y + " " + cur.dir);
      }
      if (cur.y > 0 && cur.dir != Direction.RIGHT &&  
          input[cur.x][cur.y] + reach >= input[cur.x][cur.y - 1]) {
        //System.out.println("DP: " + cur.x + " " + cur.y + " " + dp[cur.x][cur.y - 1].length);
        if (dp[cur.x][cur.y - 1] < cur.length + 1) {
          int newdelta = cur.delta;
          if (input[cur.x][cur.y] > input[cur.x][cur.y - 1]) {
            newdelta = Math.min(50, newdelta + input[cur.x][cur.y] - input[cur.x][cur.y - 1]);
          } else {
            newdelta = newdelta - (input[cur.x][cur.y - 1] - input[cur.x][cur.y]) * 5;
          }
          dp[cur.x][cur.y - 1] = cur.length + 1;
          search.add(new State(cur.x, cur.y - 1, cur.length + 1, newdelta, Direction.LEFT));
        }    
      }
      
      if (cur.x < n - 1 && cur.dir != Direction.UP && 
          input[cur.x][cur.y] + reach >= input[cur.x + 1][cur.y]) {
        if (dp[cur.x + 1][cur.y] < cur.length + 1) {
          int newdelta = cur.delta;
          if (input[cur.x][cur.y] > input[cur.x + 1][cur.y]) {
            newdelta = Math.min(50, newdelta + input[cur.x][cur.y] - input[cur.x + 1][cur.y]);
          } else {
            newdelta = newdelta - (input[cur.x + 1][cur.y] - input[cur.x][cur.y]) * 5;
          }
          dp[cur.x + 1][cur.y] = cur.length + 1;
          search.add(new State(cur.x + 1, cur.y, cur.length + 1, newdelta, Direction.DOWN));
        }    
      }
      
      if (cur.y < m - 1 && cur.dir != Direction.LEFT &&
          input[cur.x][cur.y] + reach >= input[cur.x][cur.y + 1]) {
        if (dp[cur.x][cur.y + 1] < cur.length + 1) {
          int newdelta = cur.delta;
          if (input[cur.x][cur.y] > input[cur.x][cur.y + 1]) {
            newdelta = Math.min(50, newdelta + input[cur.x][cur.y] - input[cur.x][cur.y + 1]);
          } else {
            newdelta = newdelta - (input[cur.x][cur.y + 1] - input[cur.x][cur.y + 1]) * 5;
          }
          dp[cur.x][cur.y + 1] = cur.length + 1;
          search.add(new State(cur.x, cur.y + 1, cur.length + 1, newdelta, Direction.RIGHT));
        }    
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
    new Bloomberg2().run();
  }
}
