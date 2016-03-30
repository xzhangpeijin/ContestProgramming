package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PriceCorrect {
  
  public void solve() throws IOException {
    int tests = nextInt();
    for (int t = 0; t < tests; t++) {
      int n = nextInt();
      long p = nextLong();
      
      long[] in = new long[n];
      long[] sums = new long[n];
      for (int i = 0; i < n; i++) {
        long input = nextLong();
        in[i] = input;
        if (i == 0) {
          sums[i] = input;
        } else {
          sums[i] = sums[i - 1] + input;
        }
      }
      
      long total = 0;
      for (int i = 0; i < n; i++) {
        if (in[i] > p) {
          continue;
        }
        long target = sums[i] + (p - in[i]);
        int search = Arrays.binarySearch(sums, i, n, target);
        if (search >= 0) {
          total += search + 1 - i;
        } else {
          int insertion = (search + 1) * -1;
          total += insertion - i;
          //System.out.println(i + " " + insertion);
        }
      }
      System.out.format("Case #%d: %d%n", t + 1, total);
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
    new PriceCorrect().run();
  }
}
