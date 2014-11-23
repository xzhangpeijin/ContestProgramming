package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Too slow times out
 */
public class C279 {

  public void solve() throws IOException {
    String input = nextLine();
    BigInteger a = BigInteger.valueOf(nextInt());
    BigInteger b = BigInteger.valueOf(nextInt());
    
    if (input.charAt(0) == '0') {
      System.out.println("NO");
      return;
    }
    
    for (int x = 1; x < input.length(); x++) {
      String first = input.substring(0, x);
      String second = input.substring(x, input.length());
      if (second.charAt(0) != '0') {
        BigInteger n = new BigInteger(first);
        BigInteger m = new BigInteger(second);
        if (n.mod(a).equals(BigInteger.ZERO) && m.mod(b).equals(BigInteger.ZERO)) {
          System.out.println("YES");
          System.out.println(first);
          System.out.println(second);
          return;
        }
      }
    }
    System.out.println("NO");
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
    new C279().run();
  }
}
