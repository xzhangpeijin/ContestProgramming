package contests.completed.google;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class OldHousePancakes {
  public void solve() throws IOException {
    int tests = nextInt();
    for (int t = 1; t <= tests; t++) {
      int diners = nextInt();
      TreeMap<Integer, Integer> counts = new TreeMap<Integer, Integer>();
      for (int d = 0; d < diners; d++) {
        int cakes = nextInt();
        if (counts.containsKey(cakes)) {
          counts.put(cakes, counts.get(cakes) + 1);
        } else {
          counts.put(cakes, 1);
        }
      }
      int mintime = counts.lastKey();
      int highest = mintime, time = 0;
      while (highest > 3) {
        mintime = Math.min(mintime, highest);
        
        mintime = Math.min(mintime, highest + time);
      }
      out.format("Case #%d: %d%n", t, mintime);
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
    oj = false;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new OldHousePancakes().run();
  }
}
