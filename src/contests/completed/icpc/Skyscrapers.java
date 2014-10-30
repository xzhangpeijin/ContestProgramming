package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Not correct
 */
public class Skyscrapers {
  
  public void solve() throws IOException {
    int n = 0, left = 0, right = 0;
    while ((n = nextInt()) != 0 && 
        (left = nextInt()) != 0 &&
        (right = nextInt()) != 0) {
      BigInteger mod = BigInteger.valueOf(1000000007L);
      
      if (left == 1 && right == 1 && n == 1) {
        System.out.println(1);
        continue;
      }
      if (left + right - 1 > n || left + right < 3) {
        System.out.println(0);
        continue;
      }
      
      BigInteger count = BigInteger.valueOf(1);
      for (int x = 0; x < left + right - 3; x++) {
        count = count.multiply(BigInteger.valueOf(n - 2 - x));
        count = count.mod(mod);
        count = count.multiply(BigInteger.valueOf(x + 1).modInverse(mod));
        count = count.mod(mod);
      }
      
      //System.out.println(count.toString());
      
      for (int x = 0; x < left - 1; x++) {
        count = count.multiply(BigInteger.valueOf(left + right - 2 - x));
        count = count.mod(mod);
        count = count.multiply(BigInteger.valueOf(x + 1).modInverse(mod));
        count = count.mod(mod);
      }
      
      //System.out.println(count.toString());
      
      for (int x = 2; x <= n - left - right + 1; x++) {
        count = count.multiply(BigInteger.valueOf(x));
        count = count.mod(mod);
      }
      
      System.out.println(count.toString());
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
    new Skyscrapers().run();
  }
}
