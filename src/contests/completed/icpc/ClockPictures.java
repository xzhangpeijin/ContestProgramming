package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ClockPictures {
  private static final int PRIME = 31;
  private static final long MOD = 75386881L;

  private long modexp (int n) {
    if (n == 0)
      return 1;
    long t = modexp (n/2);
    if (n % 2 == 0) 
      return (t * t) % MOD;
    else
      return (t * t * PRIME) % MOD;
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int[] first = new int[n];
    int[] second = new int[n];
    for (int x = 0; x < n; x++) {
      first[x] = nextInt();
    }
    for (int x = 0; x < n; x++) {
      second[x] = nextInt();
    }
    Arrays.sort(first);
    Arrays.sort(second);

    int[] search = new int[n];
    int[] ref = new int[n];

    for (int x = 1; x <= n; x++) {
      if (x != n) {
        search[x - 1] = first[x] - first[x - 1];
        ref[x - 1] = second[x] - second[x - 1];
      } else {
        search[x - 1] = 360000 + first[0] - first[x - 1];
        ref[x - 1] = 360000 + second[0] - second[x - 1];
      }
    }
//    for (int x = 0; x < n; x++) {
//      System.out.print(search[x] + " ");
//    }
//    System.out.println();
//    for (int x = 0; x < n; x++) {
//      System.out.print(ref[x] + " ");
//    }
//    System.out.println();
    
    long target = 0;
    long hash = 0;
    for (int x = 0; x < n; x++) {
      long power = modexp(n - x - 1);
      target += power * ref[x];
      hash += power * search[x];
      target %= MOD;
      hash %= MOD;
    }
    if (target < 0) {
      target += MOD;
    }
    if (hash < 0) {
      hash += MOD;
    }
    
    for (int x = 0; x < n; x++) {
      if (hash == target && matches(search, ref, x)) {
        System.out.println("possible");
        return;
      }
      hash -= modexp(n - 1) * search[x];
      hash *= PRIME;
      hash += search[x];
      hash %= MOD;
      if (hash < 0) {
        hash += MOD;
      }
      //System.out.println(hash + " " + target);
    }
    System.out.println("impossible");
  }
  
  public boolean matches(int[] search, int[] ref, int offset) {
    int index = offset;
    for (int x = 0; x < search.length; x++) {
      if (ref[x] != search[index])
        return false;
      index++;
      if (index == search.length) {
        index = 0;
      }
    }
    return true;
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
    new ClockPictures().run();
  }
}
