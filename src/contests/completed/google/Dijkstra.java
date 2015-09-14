package contests.completed.google;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dijkstra {
  private static class State {
    long index;
    char value;
    boolean negative;
    int state; // 0 for getting i, 1 for getting j, 2 for getting k
    
    public State(long index, char value, boolean negative, int state) {
      this.index = index;
      this.value = value;
      this.negative = negative;
      this.state = state;
    }
  }
  
  public void solve() throws IOException {
    int tests = nextInt();
    for (int t = 0; t < tests; t++) {
      int length = nextInt();
      int repeats = nextInt();
      String input = nextLine();
      StringBuffer string = new StringBuffer();
      for (int x = 0; x < repeats; x++) {
        string.append(input);
      }
      
      boolean possible = false;
      
      State start = new State(0, '1', false, 0);
      
      Queue<State> search = new LinkedList<State>();
      search.add(start);
      while(search.size() > 0) {
        State cur = search.poll();
        //char value = multiply(cur.value, string.charAt(cur.index));
      }
      out.format("Case #%d: %s", t + 1, (possible) ? "YES" : "NO");
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
    new Dijkstra().run();
  }
}
