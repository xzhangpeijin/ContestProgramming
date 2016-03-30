package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Happy {
  public int transform(int input) {
    int total = 0;
    while (input > 0) {
      int mod = input % 10;
      total += mod * mod;
      input /= 10;
    }
    return total;
  }
  
  public void solve() throws IOException {
    String nextline;
    while ((nextline = nextLine()) != null && nextline.length() > 0) {
      int input = Integer.parseInt(nextline);
      Set<Integer> seen = new HashSet<Integer>();
      seen.add(input);
      boolean happy = true;
      int count = 0;
      while (input != 1) {
        count++;
        input = transform(input);
        if (seen.contains(input)) {
          happy = false;
          break;
        }
        seen.add(input);
      }
      System.out.format("%s %d%n", happy ? "happy" : "unhappy", count);
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
    new Happy().run();
  }
}
