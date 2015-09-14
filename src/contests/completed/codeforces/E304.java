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

public class E304 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    
    int total = 0;
    
    int[] cur = new int[n];
    int[] target = new int[n];
    for (int x = 0; x < n; x++) {
      cur[x] = nextInt();
      total += cur[x];
    }
    for (int x = 0; x < n; x++) {
      target[x] = nextInt();
      total -= cur[x];
    }
    
    List<Integer>[] edges = new List[n];
    for (int x = 0; x < n; x++) {
      edges[x] = new ArrayList<Integer>();
    }
   
    for (int x = 0; x < m; x++) {
      int p = nextInt();
      int q = nextInt();
      edges[p - 1].add(q - 1);
      edges[q - 1].add(p - 1);
    }
    
    if (total != 0) {
      System.out.println("NO");
      return;
    }
    
    for (int x = 0; x < n; x++) {
      if (target[x] > cur[x]) {
        int possible = 0;
        for (int neighbor : edges[x]) {
          possible += cur[neighbor];
        }
        if (possible < target[x] - cur[x]) {
          System.out.println("NO");
          return;
        }
      }
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
    new E304().run();
  }
}
