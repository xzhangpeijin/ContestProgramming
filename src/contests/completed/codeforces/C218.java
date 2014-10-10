package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class C218 {
  public void solve() throws IOException {
    String burger = nextLine();
    int bread = nextInt();
    int sausage = nextInt();
    int cheese = nextInt();
    int bprice = nextInt();
    int sprice = nextInt();
    int cprice = nextInt();
    BigInteger money = new BigInteger(nextLine());

    int bcount = burger.length() - burger.replaceAll("B", "").length();
    int scount = burger.length() - burger.replaceAll("S", "").length();
    int ccount = burger.length() - burger.replaceAll("C", "").length();

    int burgerprice = bcount * bprice + scount * sprice + ccount * cprice;
    int count = 0;
    while (bread > 0 || sausage > 0 || cheese > 0) {
      if (bread >= bcount)
        bread -= bcount;
      else {
        money = money.subtract(new BigInteger(String.valueOf(bprice * (bcount - bread))));
        bread = 0;
      }

      if (sausage >= scount)
        sausage -= scount;
      else {
        money = money.subtract(new BigInteger(String.valueOf(sprice * (scount - sausage))));
        sausage = 0;
      }

      if (cheese >= ccount)
        cheese -= ccount;
      else {
        money = money.subtract(new BigInteger(String.valueOf(cprice * (ccount - cheese))));
        cheese = 0;
      }

      // System.out.println(money.toString());

      if (money.compareTo(new BigInteger("0")) < 0) {
        System.out.println(count);
        return;
      }
      count++;

      // System.out.println(bread + " " + sausage + " " + cheese);
    }
    BigInteger additional = money.divide(new BigInteger(String.valueOf(burgerprice)));
    System.out.println(additional.add(new BigInteger(String.valueOf(count))).toString());
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
    new C218().run();
  }
}
