package contests.completed.usaco;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GuardMark {
  static class Cow {
    public final long height, weight, strength;
    
    public Cow(long height, long weight, long strength) {
      this.height = height;
      this.weight = weight;
      this.strength = strength;
    }
  }
  
  static class State {
    public int bitmap;
    public long safety;
    public long height;
    
    public State() {
      this.bitmap = 0;
      this.safety = Long.MAX_VALUE;
      this.height = 0;
    }
    
    public State(State prev, Cow next, int index) {
      this.bitmap = prev.bitmap | (1 << index);
      this.safety = Math.min(prev.safety - next.weight, next.strength);
      this.height = prev.height + next.height;
    }
  }
  
  static final Comparator<Cow> STRENGTH_CMP = new Comparator<Cow>() {
    @Override
    public int compare(Cow a, Cow b) {
      return Long.valueOf(a.strength).compareTo(b.strength);
    }
  };
  
  public void solve() throws IOException {
    int N = nextInt();
    long H = nextLong();
    Cow[] cows = new Cow[N];
    long total = 0;
    for (int x = 0; x < N; x++) {
      cows[x] = new Cow(nextLong(), nextLong(), nextLong());
      total += cows[x].height;
    }
    if (total >= H) {      
      State init = new State();
      
      long[] dp = new long[1 << 21];
      Queue<State> search = new LinkedList<State>();
      
      dp[init.bitmap] =  init.safety;
      search.add(init);
      
      long max = -1;
      
      while (search.size() > 0) {
        //System.out.println(search.size());
        State cur = search.poll();
        if (dp[cur.bitmap] == cur.safety) {
          for (int x = 0; x < cows.length; x++) {
            if ((cur.bitmap & (1 << x)) == 0 && cows[x].weight <= cur.safety) {
              State next = new State(cur, cows[x], x);
              //System.out.println(Integer.toBinaryString(cur.bitmap) + " " + Integer.toBinaryString(next.bitmap));
              if (next.height >= H) {
                if (next.safety > max) {
                  //System.out.println(Integer.toBinaryString(next.bitmap));
                  max = next.safety;
                }
              } else if (dp[next.bitmap] == 0 || dp[next.bitmap] < next.safety) {
                dp[next.bitmap] = next.safety;
                search.add(next);
              }
            }
          }
        }
      }
      
      if (max > 0) {
        out.println(max);
      } else {
        fail();
      }
    } else {
      fail();
    }
  }
  
  public void fail() {
    out.println("Mark is too tall");
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
    oj = false;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("guard.in")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("guard.out"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new GuardMark().run();
  }
}
