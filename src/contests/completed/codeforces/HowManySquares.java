package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class HowManySquares {
  private static String VERTICAL = "VERTICAL";
  private static String HORIZONTAL = "HORIZONTAL";

  public static int GCD(int a, int b) {
    if (b==0) return a;
    return GCD(b,a%b);
  }

  static class Line {
    public int a;
    public int b;
    public int c;

    public Line(int x1, int y1, int x2, int y2) {
      a = -(y2 - y1);
      b = x2 - x1;
      c = -1 * (y1 * (x2 - x1) - x1 * (y2 - y1));

      int gcd = GCD(GCD(a, b), c);
      a /= gcd;
      b /= gcd;
      c /= gcd;
      
      if (b < 0) {
        b *= -1;
        a *= -1;
        c *= -1;
      }
      
      if (b == 0 && a < 0) {
        a *= -1;
        c *= -1;
      }
      if (a == 0 && b < 0) {
        b *= -1;
        c *= -1;
      }
    }

    public String slopeCode() {
      if (Math.abs(a) == 0) {
        return HORIZONTAL;
      } else if (Math.abs(b) == 0) {
        return VERTICAL;
      } else {
        return a + ":" + b;
      }
    }
  }

  public String reci(String a) {
    if (a.equals(HORIZONTAL)) {
      return VERTICAL;
    } else if (a.equals(VERTICAL)) {
      return HORIZONTAL;
    } else {
      String[] dat = a.split(":");
      if (dat[0].indexOf("-") == 0) {
        return dat[1] + ":" + dat[0].substring(1);
      } else {
        return "-" + dat[1] + ":" + dat[0];
      }
    }
  }

  public void solve() throws IOException {
    int n = nextInt();

    Map<String, List<Line>> linemap = new HashMap<String, List<Line>>();

    for (int x = 0; x < n; x++) {
      Line line = new Line(nextInt(), nextInt(), nextInt(), nextInt());
      String slope = line.slopeCode();
      //System.out.println(line.a + " " + line.b + " " + line.c);
      if (!linemap.containsKey(slope)) {
        linemap.put(slope, new ArrayList<Line>());
      }
      linemap.get(slope).add(line);
    }

    Map<String, Map<Double, Integer>> distmap = 
        new HashMap<String, Map<Double, Integer>>();
    for (String slope : linemap.keySet()) {
      HashMap<Double, Integer> distcount = new HashMap<Double, Integer>();
      List<Line> lines = linemap.get(slope);
      for (int x = 0; x < lines.size(); x++) {
        for (int y = x + 1; y < lines.size(); y++) {
          double dist = getDistance(lines.get(x), lines.get(y));
          //System.out.println(slope + " " + x + " " + y + " " + dist);
          if (!distcount.containsKey(dist)) {
            distcount.put(dist, 0);
          }
          distcount.put(dist, distcount.get(dist) + 1);
        }
      }
      distmap.put(slope, distcount);
    }

    long squares = 0;
    for (String slope : distmap.keySet()) {
      //System.out.println(slope);
      String reci = reci(slope);
      if (distmap.containsKey(reci)) {
        //System.out.println(slope + " " + reci);
        Map<Double, Integer> slopemap = distmap.get(slope);
        Map<Double, Integer> recimap = distmap.get(reci);
        Set<Double> shared = new HashSet<Double>(slopemap.keySet());
        shared.retainAll(recimap.keySet());
        for (double dist : shared) {
          //System.out.println(dist + " " + slopemap.get(dist) + " " + recimap.get(dist));
          squares += slopemap.get(dist) * recimap.get(dist);
        }
      }
    }
    squares /= 2;
    System.out.println(squares);
  }

  public double getDistance(Line a, Line b) {
    //System.out.println(a.a + " " + a.b + " " + a.c);
    //System.out.println(b.a + " " + b.b + " " + b.c);
    return Math.abs(a.c - b.c) / Math.pow(a.a * b.a + a.b * b.b, 0.5);
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
    new HowManySquares().run();
  }
}
