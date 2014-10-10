package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ACMDPhoto {
  public void solve() throws IOException {
    int num = 0;
    while (true) {
      num++;
      int n = nextInt();
      int x = nextInt();
      int y = nextInt();
      int f = nextInt();
      if (n == 0 && x == 0 && y == 0 && f == 0)
        break;
      if (n == 0) {
        System.out.println("Case " + num + ": 0");
      } else if (n == 1) {
        System.out.println("Case " + num + ": 1");
      } else {
        ArrayList<Double> people = new ArrayList<Double>();
        for (int p = 0; p < n; p++) {
          double xco = nextInt() - x;
          double yco = nextInt() - y;
          if (xco == 0 && yco > 0 && !people.contains(90.0))
            people.add(90.0);
          else if (xco == 0 && yco < 0 && !people.contains(270.0))
            people.add(270.0);
          else if (xco > 0 && yco == 0 && !people.contains(0.0))
            people.add(0.0);
          else if (xco < 0 && yco == 0 && !people.contains(180.0))
            people.add(180.0);
          else if (xco != 0 && yco != 0) {
            double result = 180 / Math.PI * Math.atan(yco / xco);
            if (xco > 0 && yco < 0)
              result += 360;
            if (xco < 0 && yco > 0)
              result += 180;
            if (xco < 0 && yco < 0)
              result += 180;
            if (!people.contains(result))
              people.add(result);
          }
        }
        Collections.sort(people);

        int mincount = n;
        for (int p = 0; p < people.size(); p++) {
          int count = 1;
          double cutoff = people.get(p) + f;
          for (int q = p + 1; q != p && q != p + people.size(); q++) {
            // System.out.println(q + " " + p);
            if (q == people.size()) {
              q -= people.size();
              cutoff -= 360;
            }
            if (people.get(q) > cutoff) {
              count++;
              cutoff = people.get(q) + f;
            }
          }
          if (count < mincount) {
            mincount = count;
            // System.out.println("min " + p + " " + mincount);
          }
          // System.out.println("count " + count);
        }

        System.out.println("Case " + num + ": " + mincount);
        // for(int p = 0; p < people.size(); p++)
        // System.out.println(people.get(p));
      }
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
    new ACMDPhoto().run();
  }
}
