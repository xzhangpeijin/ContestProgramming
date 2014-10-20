package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B274 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int l = nextInt();
    int girl = nextInt();
    int boy = nextInt();
    int tot = girl + boy;
    int diff = boy - girl;
    
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = nextInt();
    }
    
    boolean hasgirl = false;
    boolean hasboy = false;
    boolean hastot = false;
    int totmark = -1;
    
    for (int x = 0; x < n; x++) {
      if (hasboy && hasgirl) break;
      
      if (!hasboy && a[x] + boy <= l) {
        int iboy = Arrays.binarySearch(a, x + 1, n, a[x] + boy);
        hasboy |= (iboy >= 0);
      }
      if (!hasgirl && a[x] + girl <= l) {
        int igirl = Arrays.binarySearch(a, x + 1, n, a[x] + girl);
        hasgirl |= (igirl >= 0);
      }
      if (!hastot && a[x] + tot <= l) {
        int itot = Arrays.binarySearch(a, x + 1, n, a[x] + tot);
        hastot |= (itot >= 0);
        totmark = a[x] + girl;
      }
      if (!hastot && a[x] + diff <= l) {
        int itot = Arrays.binarySearch(a, x + 1, n, a[x] + diff);
        if (itot >= 0) {
          if (a[x] + boy <= l) {
            hastot = true;
            totmark = a[x] + boy;
          } else if (a[x] - girl >= 0) {
            hastot = true;
            totmark = a[x] - girl;
          }
        }
      }
    }
    
    if (hasgirl && hasboy) {
      System.out.println(0);
    } else if (!hasgirl && !hasboy && !hastot) {
      System.out.println(2);
      System.out.println(girl + " " + boy);
    } else if (hastot) {
      System.out.println(1);
      System.out.println(totmark);
    } else if (!hasgirl) {
      System.out.println(1);
      System.out.println(girl);
    } else if (!hasboy) {
      System.out.println(1);
      System.out.println(boy);
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
    new B274().run();
  }
}
