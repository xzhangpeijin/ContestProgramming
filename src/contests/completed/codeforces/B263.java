package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B263 {
  public class Letter implements Comparable<Letter> {
    public int count;
    public char letter;

    @Override
    public int compareTo(Letter arg0) {
      return arg0.count - count;
    }

    public Letter(char letter) {
      this.count = 0;
      this.letter = letter;
    }

    public void addCount() {
      count++;
    }

    public String toString() {
      return letter + ":" + count;
    }
  }

  public void solve() throws IOException {
    int n = nextInt();
    int k = nextInt();

    Letter[] letters = new Letter[26];
    for (int x = 0; x < 26; x++) {
      letters[x] = new Letter((char) (x + 65));
    }

    String cards = nextLine();
    for (int x = 0; x < n; x++) {
      letters[cards.charAt(x) - 65].addCount();
    }
    Arrays.sort(letters);

    int total = 0;
    for (int x = 0; x < 26; x++) {
      int count = Math.min(k, letters[x].count);
      total += count * count;
      k -= count;
      if (k == 0) {
        break;
      }
    }
    System.out.println(total);
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
    new B263().run();
  }
}
