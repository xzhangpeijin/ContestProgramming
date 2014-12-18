package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A283 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    
    char[][] arr = new char[n][m];
    for (int x = 0; x < n; x++) {
      arr[x] = br.readLine().toCharArray();
    }
    
    Set<Integer> removed = new HashSet<Integer>();
    for (int y = 0; y < m; y++) {
      for (int x = 1; x < n; x++) {
        if (arr[x][y] < arr[x - 1][y]) {
          if (!search(arr, x, y, removed)) {
            removed.add(y);
            break;
          }
        }
      }
    }
    
    System.out.println(removed.size());
  }
  
  private static boolean search(char[][] arr, int x, int y, Set<Integer> removed) {
    for (int i = y - 1; i >= 0; i--) {
      if (!removed.contains(i)) {
        if (arr[x][i] > arr[x - 1][i]) {
          return true;
        }
      }
    }
    return false;
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
    new A283().run();
  }
}
