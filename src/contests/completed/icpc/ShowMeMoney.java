package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

/** 
 * DOESNT WORK FOR SOME REASON
 * 
 * Doesn't work becuase of double precision need to change to BigDecimal to get solution
 */
@SuppressWarnings("unused")
public class ShowMeMoney {

  class Exchange {
    double[][] rates = new double[8][8];
    HashMap<String, Integer> names = new HashMap<String, Integer>();
    int index;

    public Exchange() {
      this.index = 0;
    }

    public void addExchange(String cur1, int val1, String cur2, int val2) {
      if (!names.containsKey(cur1)) {
        names.put(cur1, index);
        index++;
      }
      if (!names.containsKey(cur2)) {
        names.put(cur2, index);
        index++;
      }

      int cur1ind = names.get(cur1);
      int cur2ind = names.get(cur2);

      double ex1to2 = (double) val1 / val2;
      double ex2to1 = (double) val2 / val1;

      rates[cur1ind][cur2ind] = ex1to2;
      rates[cur2ind][cur1ind] = ex2to1;
    }

    class State {
      int state;
      Set<Integer> visited;
      double rate;

      public State(int state, double rate, Set<Integer> visited) {
        this.state = state;
        this.visited = visited;
        this.rate = rate;
        this.visited.add(state);
      }

      public State(int state) {
        this(state, 1, new HashSet<Integer>());
      }

      public State visit(int newstate, double rate) {
        return new State(newstate, this.rate * rate, new HashSet<Integer>(this.visited));
      }
    }

    public double search(int start, int target) {
      List<State> bfs = new LinkedList<State>();
      State init = new State(start);
      bfs.add(init);
      while (bfs.size() > 0) {
        State cur = bfs.remove(0);
        int state = cur.state;
        if (state == target) {
          return cur.rate;
        }

        for (int x = 0; x < 8; x++) {
          if (rates[x][state] != 0 && !cur.visited.contains(x)) {
            State newstate = cur.visit(x, rates[x][state]);
            bfs.add(newstate);
          }
        }
      }
      return 0;
    }

    public String exchange(String cur, int target) {
      int curind = names.get(cur);
      double min = Double.MAX_VALUE;
      String result = null;
      for (Entry<String, Integer> currency : names.entrySet()) {
        if (!currency.getKey().equals(cur)) {
          double rate = search(curind, currency.getValue());
          if (rate != 0) {
            int needed = Math.min((int) Math.ceil(target * rate), 100000);
            System.out.println(needed);
            System.out.println(needed / rate);
            if (needed / rate >= target) {
              double diff = needed / rate - (double) target;          
              if (diff < min) {
                min = diff;
                result = needed + " " + currency.getKey();
              }
            }
          }
        }
      }
      return result;
    }

    public void print() {
      for (int x = 0; x < 8; x++) {
        for (int y = 0; y < 8; y++) {
          System.out.print(rates[x][y] + " ");
        }
        System.out.println();
      }
    }
  }

  public void solve() throws IOException {
    int n;
    int num = 0;
    ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
    ArrayList<String> output = new ArrayList<String>();
    while ((n = nextInt()) != 0) {
      ArrayList<String> test = new ArrayList<String>();
      test.add(String.valueOf(n));
      num++;
      Exchange exchange = new Exchange();
      for (int x = 0; x < n; x++) {
        String[] in = nextLine().split(" = ");
        test.add(in[0] + " = " + in[1]);
        String[] cur1 = in[0].split(" ");
        String[] cur2 = in[1].split(" ");
        exchange.addExchange(cur1[1], Integer.parseInt(cur1[0]),
            cur2[1], Integer.parseInt(cur2[0]));
      }
      String quan = nextToken();
      String cur = nextToken();
      test.add(quan + " " + cur);
      String max = exchange.exchange(cur, Integer.parseInt(quan));
      String result = String.format("Case %d: %s", num, max);
      output.add(result);
      input.add(test);
      System.out.println(result);
    }
    
//    BufferedReader br = new BufferedReader(new FileReader(new File("/Users/Peijin/Downloads/G.out")));
//    String nextline;
//    int index = 0;
//    while ((nextline = br.readLine()) != null) {
//      if (!output.get(index).equals(nextline)) {
//        for (String line : input.get(index)) {
//          System.out.println(line);
//        }
//        System.out.println("Correct: " + nextline);
//        System.out.println("Mine: " + output.get(index));
//        System.out.println(output.get(index).compareTo(nextline));
//      }
//      index++;
//    }
//    br.close();
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
    new ShowMeMoney().run();
  }
}
