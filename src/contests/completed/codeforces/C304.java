package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class C304 {
  static class State {
    private List<Integer> s1, s2;
    
    public State (List<Integer> s1, List<Integer> s2) {
      this.s1 = s1;
      this.s2 = s2;
    }
    
    public int winner() {
      if (s1.size() == 0) {
        return 2;
      } else if (s2.size() == 0) {
        return 1;
      } else {
        return -1;
      }
    }
    
    public State move() {
      List<Integer> ns1 = new ArrayList<Integer>(s1);
      List<Integer> ns2 = new ArrayList<Integer>(s2);
      
      int s1top = ns1.remove(0);
      int s2top = ns2.remove(0);
      if (s1top > s2top) {
        ns1.add(s2top);
        ns1.add(s1top);
      } else {
        ns2.add(s1top);
        ns2.add(s2top);
      }
            
      return new State(ns1, ns2);
    }
    
    public int hashCode() {
      return Objects.hash(s1, s2);
    }
    
    public boolean equals(Object o) {
      if (o instanceof State) {
        State s = (State) o;
        if (s.s1.size() != s1.size() || s.s2.size() != s2.size()) {
          return false;
        }
        for (int x = 0; x < s1.size(); x++) {
          if (s1.get(x) != s.s1.get(x)) {
            return false;
          }
        }
        for (int x = 0; x < s2.size(); x++) {
          if (s2.get(x) != s.s2.get(x)) {
            return false;
          }
        }
        return true;
      }
      return false;
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    List<Integer> s1 = new ArrayList<Integer>(n);
    List<Integer> s2 = new ArrayList<Integer>(n);
    int k1 = nextInt();
    for (int x = 0; x < k1; x++) {
      s1.add(nextInt());
    }
    int k2 = nextInt();
    for (int x = 0; x < k2; x++) {
      s2.add(nextInt());
    }
    
    HashSet<State> seen = new HashSet<State>();
    State cur = new State(s1, s2);
    while (cur.winner() == -1 && !seen.contains(cur)) {
      seen.add(cur);
      cur = cur.move();
    }
    
    if (cur.winner() == -1) {
      System.out.println(-1);
    } else {
      System.out.format("%d %d%n", seen.size(), cur.winner());
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
    new C304().run();
  }
}
