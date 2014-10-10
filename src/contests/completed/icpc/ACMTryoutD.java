package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACMTryoutD {
  public void solve() throws IOException {
    while (true) {
      int numtargets = nextInt();
      if (numtargets == 0)
        break;

      int[][] points = new int[numtargets + 2][3];
      for (int x = 0; x < numtargets; x++)
        for (int y = 0; y < 3; y++)
          points[x + 1][y] = nextInt();
      points[numtargets + 1][0] = 100;
      points[numtargets + 1][1] = 100;

      int pos = 0;
      double total = 0;
      while (pos != numtargets + 1) {
        int move = pos + 1;
        double distance = getdist(points[pos][0] - points[pos + 1][0], points[pos][1]
            - points[pos + 1][1]) + 1;
        double mindist = distance;
        int penalty = points[pos + 1][2];
        for (int x = pos + 2; x < numtargets + 2; x++) {
          distance += getdist(points[x - 1][0] - points[x][0], points[x - 1][1] - points[x][1]) + 1;
          double newdist = getdist(points[pos][0] - points[x][0], points[pos][1] - points[x][1]) + 1;
          newdist += penalty;
          System.out.println(distance + " " + newdist);
          if (newdist < distance) {
            move = x;
            mindist = newdist;
          }
          penalty += points[x][2];
        }
        System.out.println(move);
        pos = move;
        total += mindist;
      }

      System.out.println(total);

      // DecimalFormat df = new DecimalFormat("#.00");
      // System.out.println(df.format((double)Math.round(1 * 100) / 100));
    }
  }

  public double getdist(int x, int y) {
    return Math.pow(x * x + y * y, 0.5);
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
    boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    oj = true;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("output.txt"));

    solve();

    out.close();
  }

  public static void main(String[] args) throws IOException {
    new ACMTryoutD().run();
  }
}
