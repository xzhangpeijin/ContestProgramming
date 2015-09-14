package contests.completed.google;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class HousePancakes {

  public void solve() throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      int d = nextInt();
      TreeMap<Integer, Integer> counts = new TreeMap<Integer, Integer>();
      for (int j = 0; j < d; j++) {
        int cakes = nextInt();
        if (!counts.containsKey(cakes)) {
          counts.put(cakes, 1);
        } else {
          counts.put(cakes, counts.get(cakes) + 1);
        }
      }
      
      int mintime = counts.lastKey();
      int time = 0, highest = mintime;
      while (highest > 3) {
        if (highest % 2 == 0) {
          if (!counts.containsKey(highest / 2)) {
            counts.put(highest / 2, counts.get(highest));
          } else {
            counts.put(highest / 2, counts.get(highest / 2) + counts.get(highest));
          }
        } else {
          if (!counts.containsKey(highest / 2 + 1)) {
            counts.put(highest / 2 + 1, counts.get(highest));
          } else {
            counts.put(highest / 2 + 1, counts.get(highest / 2 + 1) + counts.get(highest));
          }
        }
        if (!counts.containsKey(highest / 2)) {
          counts.put(highest / 2, counts.get(highest));
        } else {
          counts.put(highest / 2, counts.get(highest / 2) + counts.get(highest));
        }
        time = time + counts.get(highest);
        highest = counts.floorKey(highest - 1);
        mintime = Math.min(highest + time, mintime);
      }
      out.format("Case #%d: %d%n", i + 1, Math.min(mintime, time + highest));
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
    new HousePancakes().run();
  }
}
