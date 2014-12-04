package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fix {
  
  public void solve() throws IOException {
    int n = nextInt();
    for (int i = 0; i < n; i++) {
      String a = nextLine();
      String b = nextLine();
      String c = nextLine();
      if (a.startsWith(b) || a.startsWith(c) || 
          b.startsWith(a) || b.startsWith(c) ||
          c.startsWith(a) || c.startsWith(b) ||
          a.endsWith(b) || a.endsWith(c) ||
          b.endsWith(a) || b.endsWith(c) ||
          c.endsWith(a) || c.endsWith(b)) {
        System.out.println("No");
      } else {
        System.out.println("Yes");
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
    new Fix().run();
  }
}
