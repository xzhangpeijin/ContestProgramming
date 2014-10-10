package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B202 {
  public void solve() throws IOException {
    int v = nextInt();
    int[] digits = new int[9];
    for (int x = 0; x < 9; x++)
      digits[x] = nextInt();

    int smallest = 100001;
    int digit = -1;
    for (int x = 0; x < 9; x++) {
      if (digits[x] <= smallest) {
        smallest = digits[x];
        digit = x + 1;
      }
    }

    int length = v / smallest;

    if (length == 0)
      System.out.println("-1");
    else {
      char[] result = new char[length];
      for (int x = 0; x < length; x++)
        result[x] = (char) (digit + 48);

      v -= smallest * length;
      boolean canadd = true;
      int index = 0;
      while (v > 0 && canadd) {
        int max = v + smallest;
        int largest = smallest;
        int bigdig = -1;
        for (int x = 0; x < 9; x++) {
          if (digits[x] <= max && digits[x] >= largest) {
            largest = digits[x];
            bigdig = x + 1;
          }
        }
        v -= digits[bigdig - 1] - smallest;
        if (bigdig != digit)
          result[index] = (char) (bigdig + 48);
        else
          canadd = false;
        index++;
      }

      System.out.println(new String(result));
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
    new B202().run();
  }
}
