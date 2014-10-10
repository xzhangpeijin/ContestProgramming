package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Burnout {

  public static class Pattern {
    public boolean flip;
    public long offtime;
    public long ontime;
    public long length;
    public List<Pattern> subpattern = new LinkedList<Pattern>();

    public static Pattern parsePattern(String input) {
      return new Pattern();
    }
  }

  public void solve() throws IOException {
    // long n;
    // while ((n = nextLong()) != 0)
    // {
    // String input = nextLine();
    // Pattern pattern = Pattern.parsePattern(input);
    // boolean on = true;
    // long old = -1;
    // long elapsed = 0;
    // while (elapsed < n)
    // {
    // elapsed++;
    // }
    // }
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
    new Burnout().run();
  }
}
