package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Not correct, currently times out
 */
public class StarSimulations {
  class Point {
    public int x;
    public int y;
    public int z;

    public Point(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
    
    public String toString() {
      return x + " " + y + " " + z;
    }
    
    public boolean equals(Point a) {
      return a.x == x && a.y == y && a.z == z;
    }
  }
  public void solve() throws IOException {
    int n = 0, k = 0;

    while ((n = nextInt()) != 0 && (k = nextInt()) != 0) {
      Point[] points = new Point[n];
      for (int x = 0; x < n; x++) {
        points[x] = new Point(nextInt(), nextInt(), nextInt());
      }
      
      Point[] xlist = new Point[n];
      int[] xco = new int[n];
      Point[] ylist = new Point[n];
      int[] yco = new int[n];
      Point[] zlist = new Point[n];
      int[] zco = new int[n];
      for (int x = 0; x < n; x++) {
        xlist[x] = points[x];
        xco[x] = points[x].x;
        ylist[x] = points[x];
        yco[x] = points[x].y;
        zlist[x] = points[x];
        zco[x] = points[x].z;
      }
      
      Arrays.sort(xlist, new Comparator<Point>() {
        @Override
        public int compare(Point arg0, Point arg1) {
          return arg0.x - arg1.x;
        }
      });
      Arrays.sort(xco);
      
      Arrays.sort(ylist, new Comparator<Point>() {
        @Override
        public int compare(Point arg0, Point arg1) {
          return arg1.y - arg1.y;
        }
      });
      Arrays.sort(yco);
      
      Arrays.sort(zlist, new Comparator<Point>() {
        @Override
        public int compare(Point arg0, Point arg1) {
          return arg0.z - arg1.z;
        }
      });
      Arrays.sort(zco);
      
      for (int i = 0; i < n; i++) {
        System.out.println(xlist[i].x);
        System.out.println(xco[i]);
      }
      
      int count = 0;
      for (int x = 0; x < n; x++) {
        Point point = points[x];
        
        int xstart = Math.abs(Arrays.binarySearch(xco, point.x - k) + 1);
        int xend = Math.abs(Arrays.binarySearch(xco, point.x + k) + 1);
        int xdiff = xend - xstart;
        
        int ystart = Math.abs(Arrays.binarySearch(yco, point.y - k) + 1);
        int yend = Math.abs(Arrays.binarySearch(yco, point.y + k) + 1);
        int ydiff = yend - ystart;
        
        int zstart = Math.abs(Arrays.binarySearch(zco, point.z - k) + 1);
        int zend = Math.abs(Arrays.binarySearch(zco, point.z + k) + 1);
        int zdiff = zend - zstart;
        
        if (xdiff <= ydiff && xdiff <= zdiff) {
          for (int i = xstart; i < xend; i++) {
            if (!xlist[i].equals(point) && distance(xlist[i], point) < k) {
              count++;
            }
          }
        } else if (ydiff <= xdiff && ydiff <= zdiff) {
          for (int i = ystart; i < yend; i++) {
            if (!ylist[i].equals(point) && distance(ylist[i], point) < k) {
              count++;
            }
          }
        } else {
          for (int i = zstart; i < zend; i++) {
            if (!zlist[i].equals(point) && distance(zlist[i], point) < k) {
              count++;
            }
          }
        }
      }
      System.out.println(count / 2);
    }
  }

  public double distance(Point a, Point b) {
    double xdiff = Math.pow(Math.abs(a.x - b.x), 2);
    double ydiff = Math.pow(Math.abs(a.y - b.y), 2);
    double cdiff = Math.pow(Math.abs(a.z - b.z), 2);

    return Math.pow(xdiff + ydiff + cdiff, 0.5);
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
    new StarSimulations().run();
  }
}
