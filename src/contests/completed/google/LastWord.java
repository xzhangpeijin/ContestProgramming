package contests.completed.google;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LastWord {
  
  public void solve() throws IOException {
    int T = nextInt();
    for (int t = 1; t <= T; t++) {
      String S = nextLine();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < S.length(); i++) {
        if (i == 0 || Character.compare(S.charAt(i), sb.charAt(0)) < 0) {
          sb.append(S.charAt(i));
        } else {
          sb.insert(0, S.charAt(i));
        }
      }
      out.format("Case #%d: %s\n", t, sb.toString());
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
    new LastWord().run();
  }
}
