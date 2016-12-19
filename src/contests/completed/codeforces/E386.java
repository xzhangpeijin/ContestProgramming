package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class E386 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    
    boolean[] mused = new boolean[m];
    int nexteven = 2;
    int nextodd = 1;
    
    int nevens = 0;
    int nodds = 0;
    
    int[] cards = new int[n];
    for (int i = 0; i < n; i++) {
      int card = nextInt();
      if (card <= m && mused[card-1]) {
        cards[i] = 0;
      } else {
        if (card % 2 == 0) {
          if (nevens < n/2) {
            cards[i] = card;
            nevens++;
            if (card <= m) {
              mused[card-1] = true;
            }
          } else {
            cards[i] = 0;
          }
        } else {
          if (nodds < n/2) {
            cards[i] = card;
            nodds++;
            if (card <= m) {
              mused[card-1] = true;
            }
          } else {
            cards[i] = 0;
          }
        }
      }
    }    
    
    int swaps = 0;
    StringBuilder ans = new StringBuilder(2 * n - 1);
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        ans.append(" ");
      }
      if (cards[i] != 0) {
        ans.append(cards[i]);
        continue;
      }
      
      swaps++;
      if (nevens < nodds) {
        while (nexteven < m && mused[nexteven-1]) {
          nexteven += 2;
        }
        if (nexteven >= m) {
          System.out.println(-1);
          return;
        }
        ans.append(nexteven);
        mused[nexteven-1] = true;
        nexteven += 2;
        nevens++;
      } else {
        while (nextodd < m && mused[nextodd-1]) {
          nextodd += 2;
        }
        if (nextodd >= m) {
          System.out.println(-1);
          return;
        }
        ans.append(nextodd);
        mused[nextodd-1] = true;
        nodds++;
      }
    }
    
    System.out.println(swaps);
    System.out.println(ans.toString());
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
    new E386().run();
  }
}
