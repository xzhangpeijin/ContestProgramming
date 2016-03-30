package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A343 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int[] rows = new int[n];
    int[] cols = new int[n];
    for (int i = 0; i < n; i++) {
      String input = nextLine();
      for (int j = 0; j < n; j++) {
        if (input.charAt(j) == 'C') {
          rows[i]++;
          cols[j]++;
        }
      }
    }
    long total = 0;
    for (int i = 0; i < n; i++) {
      total += rows[i] * (rows[i] - 1) / 2;
      total += cols[i] * (cols[i] - 1) / 2;
    }
    out.println(total);
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
    new A343().run();
  }
}
