package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D304 {
  static List<Integer> genPrimes(int n) {
    List<Integer> primes = new ArrayList<Integer>();
    
    boolean[] sieve = new boolean[n + 1];
    for (int x = 0; x < n + 1; x++) {
      sieve[x] = true;
    }
    for (int x = 2; x <= n; x++) {
      if (sieve[x]) {
        primes.add(x);
        int val = 2 * x;
        while (val <= n) {
          sieve[val] = false;
          val += x;
        }
      }
    }
    
    return primes;
  }
  
  static List<Integer> primes = genPrimes(5000000);

  public void solve() throws IOException {
    int t = nextInt();
    for (int x = 0; x < t; x++) {
      int a = nextInt();
      int b = nextInt();
      System.out.println(getScore(a, b));
    }
  }
  
  public int getScore(int a, int b) {
    int total = 0;
    for (int prime : primes) {
      if (prime > a) {
        break;
      }
      int val = prime;
      while (val <= a) {
        if (val > b) {
          int temp = val;
          while (temp % prime == 0) {
            total++;
            temp /= prime;
          }
        }
        val += prime;
      }
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
    new D304().run();
  }
}
