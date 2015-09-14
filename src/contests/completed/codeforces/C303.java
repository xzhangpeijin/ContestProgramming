package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C303 {
  static class Tree {
    int pos, height;
    
    public Tree(int pos, int height) {
      this.pos = pos;
      this.height = height;
    }
  }
  
  static class State {
    int nextindex;
    int trees;
    int rightmost;
    
    public State(int nextindex, int trees, int rightmost) {
      this.nextindex = nextindex;
      this.trees = trees;
      this.rightmost = rightmost;
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    Tree[] trees = new Tree[n];
    for (int x = 0; x < n; x++) {
      trees[x] = new Tree(nextInt(), nextInt());
    }
    State start = new State(0, 0, Integer.MIN_VALUE);
    Queue<State> search = new LinkedList<State>();
    search.add(start);
    
    int most = 0;
    HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
    while (search.size() > 0) {
      State cur = search.poll();
      Tree tree = trees[cur.nextindex];
      if (tree.pos - tree.height > cur.rightmost) {
        State next = new State(cur.nextindex + 1, cur.trees + 1, tree.pos);
        most = Math.max(most, cur.trees + 1);
        if (dp.containsKey(tree.pos) )
        search.add(next);
      } else {
        
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
    new C303().run();
  }
}
