

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class Helper {
  public void solve() throws IOException {
    Random a = new Random(System.currentTimeMillis());
    for (int x = 0; x < 99; x++) {
      System.out.print(100);
      switch (a.nextInt(4)) {
      case 0: System.out.println(" L"); break;
      case 1: System.out.println(" R"); break;
      case 2: System.out.println(" U"); break;
      case 3: System.out.println(" D"); break;
      }
    }
  }
  
  public boolean sorted(int[] a) {
    for (int x = 0; x < a.length - 1; x++) {
      if (a[x] > a[x + 1])
        return false;
    }
    return true;
  }
  
  public List<Integer> perfectDivisors(int n) {
    List<Integer> divisors = new ArrayList<Integer>();
    divisors.add(1);
    int sum = 1;
    for (int x = 2; x <= Math.sqrt(n); x++) {
      if (n % x == 0) {
        sum += x;
        divisors.add(x);
        if (x != Math.sqrt(n)) {
          divisors.add(n / x);
          sum += n / x;
        }
      }
    }
    //System.out.println(n + " " + sum);
    if (sum == n) {
      Collections.sort(divisors);
      return divisors;
    } else {
      return null;
    }
  }

  public String toString(int[] val) {
    StringBuilder builder = new StringBuilder();
    for (int x = 0; x < val.length; x++) {
      if (x != 0) {
        builder.append(" ");
      }
      builder.append(val[x]);
    }
    return builder.toString();
  }

  public long choose(int a, int b) {
    long total = 1;
    for (int x = 0; x < b; x++) {
      total *= (a - x);
    }
    for (int x = 1; x <= b; x++) {
      total /= x;
    }
    return total;
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
    new Helper().run();
  }
}
