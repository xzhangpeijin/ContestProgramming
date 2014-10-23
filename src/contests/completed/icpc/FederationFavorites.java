package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FederationFavorites {
  
  private static final String[] ans = {"6:1 + 2 + 3",
    "28:1 + 2 + 4 + 7 + 14","496:1 + 2 + 4 + 8 + 16 + 31 + 62 + 124 + 248",
    "8128:1 + 2 + 4 + 8 + 16 + 32 + 64 + 127 + 254 + 508 + 1016 + 2032 + 4064"};
  
  public void solve() throws IOException {
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    for (int x = 0; x < ans.length; x++) {
      String[] dat = ans[x].split(":");
      map.put(Integer.parseInt(dat[0]), dat[1]);
    }
    
    int n;
    while ((n = nextInt()) != -1) {
      if (map.containsKey(n)) {
        System.out.format("%d = %s%n", n, map.get(n));
      } else {
        System.out.format("%d is NOT perfect.%n", n);
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
    new FederationFavorites().run();
  }
}
