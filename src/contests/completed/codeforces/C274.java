package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C274 {

  public void solve() throws IOException {
    int n = nextInt();
    int a = nextInt();
    int b = nextInt();
    int k = nextInt();

    if (a > b) {
      a = n - a + 1;
      b = n - b + 1;
    }

    long[] counts = new long[b];
    counts[a] = 1;

    long oldtot = 1;
    for (int i = 0; i < k; i++) {
      //System.out.println(oldtot);
      long[] newcounts = new long[b];
      newcounts[b - 1] = (oldtot - counts[b - 1]) % 1000000007;
      long tot = newcounts[b - 1];
      int floors = 0;
      for (int x = b - 2; x >= 1; x--) {
        if (floors % 2 == 0) {
          newcounts[x] = newcounts[x + 1] - counts[x];
          newcounts[x] -= counts[x + (floors/2) + 1];
          newcounts[x] += counts[x + 1];
        } else {
          newcounts[x] = newcounts[x + 1] - counts[x] + counts[x + 1];
        }
        
        floors++;
        newcounts[x] %= 1000000007;
        if (newcounts[x] < 0) {
          newcounts[x] += 1000000007;
        }
        tot += newcounts[x];
      }
      oldtot = tot;
      
      counts = newcounts;
    }

//    for (int x = 1; x < b; x++) {
//      System.out.println(x + " " + counts[x]);
//    }

    System.out.println(oldtot % 1000000007);
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
    new C274().run();
  }
}
