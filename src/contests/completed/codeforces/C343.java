package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C343 {
  private static final long MOD = (long)(10e9 + 7);
  private static final long[][] memo = new long[2001][2001];
  
  private static long choose(int n, int k) {
    if (k == 1) {
      return n;
    } 
    if (k == 0 || k == n) {
      return 1;
    }
    
    if (memo[n][k] != 0) {
      return memo[n][k];
    }
    long result = (choose(n, k - 1) + choose(n - 1, k - 1)) % MOD;
    memo[n][k] = result;
    return result;
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    String s = nextLine();
    int pre = 0, post = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        post++;
      } else if (post != 0) {
        post--;
      } else {
        pre++;
      }
    }
    post = Math.max(0, post);
    int diff = n - m;
    int remain = diff - post - pre;
    System.out.println(remain + " " + post + " " + pre);
    if (pre + post > diff || remain % 2 != 0) {
      out.println(0);
    } else if (remain == 0) {
      out.println(1);
    } else {
      long total = 0;
      for (int i = 0; i <= remain; i++) {
        int leftlength = pre + i;
        int rightlength = post + remain - i;
        long leftcount = (choose(leftlength, i) 
            - choose(leftlength, i + 1) + MOD) % MOD;
        long rightcount = (choose(rightlength, remain - i) 
            - choose(rightlength, remain - i + 1) + MOD) % MOD;
        System.out.println(i + " " + leftcount + " " + rightcount);
        total += (leftcount * rightcount) % MOD;
        total %= MOD;
      }
      out.println(total);
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
    new C343().run();
  }
}
