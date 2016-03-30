package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boomerang {
  static class Point {
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  
  static double distance(Point a, Point b) {
    return Math.pow(Math.pow(a.x - b.x, 2) + 
                    Math.pow(a.y - b.y, 2), 0.5);
  }
  
  public void solve() throws IOException {
    int nights = nextInt();
    for (int t = 0; t < nights; t++) {
      int n = nextInt();
      List<Point> points = new ArrayList<Point>();
      for (int i = 0; i < n; i++) {
        points.add(new Point(nextInt(), nextInt()));
      }
      
      int total = 0;
      for (Point p : points) {
        Map<Double, Integer> counts = new HashMap<Double, Integer>();
        
        for (Point q : points) {
          if (p == q) {
            continue;
          }
          
          double distance = distance(p, q);
          if (!counts.containsKey(distance)) {
            counts.put(distance, 1);
          } else {
            counts.put(distance, counts.get(distance) + 1);
          }
        }
        
        for (int count : counts.values()) {
          if (count >= 2) {
            total += count * (count - 1) / 2;
          }
        }
      }
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
    new Boomerang().run();
  }
}
