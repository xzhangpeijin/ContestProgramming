package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Security {
  static class Interval {
    int start, end;
    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
  
  static List<Interval> getIntervals(String input) {
    List<Interval> intervals = new ArrayList<Interval>();
    
    int start = -1;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '.' && start == -1) {
        start = i;
      } else if (input.charAt(i) == 'X') {
        if (start != -1) {
          intervals.add(new Interval(start, i - 1));
        }
        start = -1;
      }
    }
    if (start != -1) {
      intervals.add(new Interval(start, input.length() - 1));
    }
    
    return intervals;
  }
  
  static boolean contains(Interval i, int p) {
    return i.start <= p && i.end >= p;
  }
  
  public void solve() throws IOException {
    int tests = nextInt();
    for (int t = 0; t < tests; t++) {
      int n = nextInt();
      
      List<Interval> topint = getIntervals(nextLine());
      List<Interval> botint = getIntervals(nextLine());
      
      //System.out.format("Pre: %d %d%n", topint.size(), botint.size());

      int total = 0;
      
      for (int x = 0; x < topint.size(); x++) {
        Interval i = topint.get(x);
        if (i.start == i.end) {
          for (Interval j : botint) {
            if (contains(j, i.start)) {
              botint.remove(j);
              topint.remove(x--);
              total++;
              break;
            }
          }
        }
      }
      
      for (int x = 0; x < botint.size(); x++) {
        Interval i = botint.get(x);
        if (i.start == i.end) {
          for (Interval j : topint) {
            if (contains(j, i.start)) {
              topint.remove(j);
              botint.remove(x--);
              total++;
              break;
            }
          }
        }
      }
      
      //System.out.format("Post: %d %d%n", topint.size(), botint.size());
      
      total += topint.size();
      total += botint.size();
      
      System.out.format("Case #%d: %d%n", t + 1, total);
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
    new Security().run();
  }
}
