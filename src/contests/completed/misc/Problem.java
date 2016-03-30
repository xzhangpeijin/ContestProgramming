package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Problem {
  class Point {
    double xco, yco;
    public Point(double xco, double yco) {
      this.xco = xco;
      this.yco = yco;
    }
  }
  
  class Road {
    double slope, intercept, xstart, xend;
    public Road(double slope, double intercept, double xstart, double xend) {
      this.slope = slope;
      this.intercept = intercept;
      this.xstart = Math.min(xstart, xend);
      this.xend = Math.max(xstart, xend);
    }
  }
  
  boolean intersect(Road a, Road b) {
    if (a.slope == b.slope) {
      return false;
    }
    
    double xinter = (b.intercept - a.intercept) / (a.slope - b.slope);
    return (xinter >= a.xstart && xinter <= a.xend && xinter >= b.xstart && xinter <= b.xend);
  }
  
  Road makeRoad(Point a, Point b) {
    double slope = (a.yco - b.yco) / (a.xco - b.xco);
    double intercept = a.yco - slope * a.xco;
    double xstart = Math.min(a.xco, b.xco);
    double xend = Math.max(a.xco, b.xco);
    return new Road(slope, intercept, xstart, xend);
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    Point[] path = new Point[n];
    for (int i = 0; i < n; i++) {
      String[] dat = nextLine().split(",");
      path[i] = new Point(Integer.parseInt(dat[0]), Integer.parseInt(dat[1]));
    }
    
    int r = nextInt();
    Road[] roads = new Road[r];
    for (int i = 0; i < r; i++) {
      String[] dat = nextLine().split(",");
      roads[i] = new Road(Integer.parseInt(dat[0]), Integer.parseInt(dat[1]), 
          Integer.parseInt(dat[2]), Integer.parseInt(dat[3]));
    }
    
    int count = 0;
    Point prev = path[0];
    for (int i = 1; i < n; i++) {
      Road rd = makeRoad(path[i], prev);
      
      for (Road road : roads) {
        if (intersect(rd, road)) {
          count++;
        }
      }
      prev = path[i];
    }
    System.out.println(count);
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
    new Problem().run();
  }
}
