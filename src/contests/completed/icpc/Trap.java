package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Trap {
  public void solve() throws IOException {
    while (true) {
      int n = nextInt();
      if (n == 0)
        break;
      ArrayList<Trapezoid> available = new ArrayList<Trapezoid>();
      for (int x = 0; x < n; x++)
        available.add(new Trapezoid(nextInt(), nextInt(), nextInt()));

      double cost = minCost(nextInt(), nextInt(), available);
      int dollars = (int) (2 * cost / 100);
      int cents = (int) (2 * cost) % 100;
      String str = String.valueOf(cents);
      if (cents < 10)
        str = "0" + str;
      System.out.println(dollars + "." + str);
    }
  }

  public double minCost(int curwidth, int target, ArrayList<Trapezoid> avail) {
    if (curwidth == target)
      return 0;
    Double min = Double.MAX_VALUE;
    for (int x = 0; x < avail.size(); x++) {
      for (int y = 0; y < avail.size(); y++) {
        if ((avail.get(x).base == curwidth || avail.get(x).top == curwidth)
            && (avail.get(y).base == target || avail.get(y).top == target)) {
          ArrayList<Trapezoid> newavail = new ArrayList<Trapezoid>();
          newavail.addAll(avail);
          newavail.remove(avail.get(x));
          newavail.remove(avail.get(y));
          if (x == y)
            min = Math.min(min, avail.get(x).area);
          else {
            int newwidth = avail.get(x).base;
            if (newwidth == curwidth)
              newwidth = avail.get(x).top;
            int newtarget = avail.get(y).base;
            if (newtarget == target)
              newtarget = avail.get(y).top;
            min = Math
                .min(
                    avail.get(x).area + avail.get(y).area + minCost(newwidth, newtarget, newavail),
                    min);
          }
        }
      }
    }

    return min;
  }

  public class Trapezoid {
    public int base;
    public int top;
    public int height;
    public double area;

    public Trapezoid(int base, int top, int height) {
      this.base = base;
      this.top = top;
      this.height = height;
      area = (double) (base + top) * height / 2;
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
    br = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new Trap().run();
  }
}
