package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B343 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int[] male = new int[366];
    int[] female = new int[366];
    for (int i = 0; i < n; i++) {
      boolean isMale = nextToken().equals("M");
      int start = nextInt();
      int end = nextInt();
      for (int j = start; j <= end; j++) {
        if (isMale) {
          male[j - 1]++;
        } else {
          female[j - 1]++;
        }
      }
    }
    int max = 0;
    for (int i = 0; i < 366; i++) {
      max = Math.max(max, Math.min(female[i], male[i]));
    }
    out.println(max * 2);
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
    new B343().run();
  }
}
