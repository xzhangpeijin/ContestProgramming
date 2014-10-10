package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B98 {
  public void solve() throws IOException {
    int size = nextInt();
    int[] arr = new int[size];

    for (int x = 0; x < size; x++) {
      int a = nextInt();
      if (a <= size) {
        arr[a - 1] = 1;
      }
    }

    int count = 0;
    for (int x = 0; x < size; x++)
      if (arr[x] == 0)
        count++;

    System.out.println(count);
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
    new B98().run();
  }
}
