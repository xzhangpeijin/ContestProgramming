package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backgammon {
  public void solve() throws IOException {
    ArrayList<String> index = new ArrayList<String>(15504);
    int[] val = new int[6];
    val[5] = 15;
    index.add(toString(val));
    for (int x = 1; x < 15504; x++) {
      for (int y = 5; y >= 0; y--) {
        if (val[y] != 0) {
          val[y - 1]++;
          val[y]--;
          int tot = 0;
          for (int z = y; z < 6; z++) {
            tot += val[z];
            val[z] = 0;
          }
          val[5] = tot;
          break;
        }
      }
      index.add(toString(val));
    }
    
    String act;
    int num = 0;
    while (!(act = nextToken()).equals("e")) {
      num++;
      if (act.equals("u")) {
        int i = nextInt();
        System.out.format("Case %d: %s%n", num, index.get(i));
      } else if (act.equals("m")) {
        StringBuilder build = new StringBuilder();
        for (int x = 0; x < 6; x++) {
          if (x != 0) {
            build.append(" ");
          }
          build.append(nextToken());
        }
        System.out.format("Case %d: %d%n", num, index.indexOf(build.toString()));
      }
    }
  }

  public String toString(int[] val) {
    StringBuilder builder = new StringBuilder();
    for (int x = 0; x < val.length; x++) {
      if (x != 0) {
        builder.append(" ");
      }
      builder.append(val[x]);
    }
    return builder.toString();
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
    new Backgammon().run();
  }
}
