package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACM6 {
  public void solve() throws IOException {
    boolean start = true;
    while (start) {
      String input = nextToken();
      if (input.equals("0")) {
        start = false;
        break;
      }
      char[] digits = input.toCharArray();
      char[] add = new char[digits.length];
      for (int x = 0; x < digits.length; x++)
        add[x] = 48;
      for (int x = 0; x < digits.length / 2; x++) {
        while (digits[x] != digits[digits.length - 1 - x]) {
          digits[digits.length - 1 - x]++;
          add[digits.length - 1 - x]++;
          if (digits[digits.length - 1 - x] == 58) {
            int index = x;
            while (digits[digits.length - 1 - index] == 58) {
              digits[digits.length - 1 - index] = 48;
              digits[digits.length - 2 - index]++;
              index++;
            }
          }
          if (add[digits.length - 1 - x] == 58) {
            int index = x;
            while (add[digits.length - 1 - index] == 58) {
              add[digits.length - 1 - index] = 48;
              add[digits.length - 2 - index]++;
              index++;
            }
          }
        }
      }
      int total = 0;
      for (int x = 0; x < add.length; x++) {
        total += (add[x] - 48) * Math.pow(10, add.length - 1 - x);
      }
      System.out.println(total);
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
    new ACM6().run();
  }
}
