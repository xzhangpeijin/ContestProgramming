package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WeanKeypad {
  public static class KMP {
    public static int search(String pattern, String text, int[] next) {
      int i, j;
      @SuppressWarnings("unused")
      int count = 0;
      for (i = 0, j = 0; i < text.length(); i++) {
        while (j < pattern.length()) {
          while (j >= 0 && text.charAt(i) != pattern.charAt(j)) {
            j = next[j];
          }
          j++;
        }
        count++;
        j = 0;
      }
      if (j == pattern.length())
        return i - pattern.length();
      return -1;
    }

    public static int count(String pattern, String text) {
      int[] next = createTable(pattern);
      int count = 0;
      int offset = -1;
      do {
        offset = search(pattern, text, next);
        count += (offset >= 0 ? 1 : 0);
        text = text.substring(offset + 1, text.length());
      } while (offset >= 0);
      return count;
    }

    private static int[] createTable(String pattern) {
      int[] next = new int[pattern.length()];
      int j = -1;
      for (int i = 0; i < pattern.length(); i++) {
        if (i == 0)
          next[i] = -1;
        else if (pattern.charAt(i) != pattern.charAt(j))
          next[i] = j;
        else
          next[i] = next[j];
        while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
          j = next[j];
        }
        j++;
      }
      return next;
    }
  }

  public void solve() throws IOException {
    String A = nextLine();
    String B = nextLine();

    System.out.println(KMP.count(B, A));
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
    new WeanKeypad().run();
  }
}
