package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C284 {
  
  public void solve() throws IOException {
    long xHome = nextLong();
    long yHome = nextLong();
    long xUni = nextLong();
    long yUni = nextLong();
    
    int n = nextInt();
    int count = 0;
    for (int x = 0; x < n; x++) {
      long a = nextLong();
      long b = nextLong();
      long c = nextLong();
      Long home = xHome * a + yHome * b + c;
      Long uni = xUni * a + yUni * b + c;
      if (home > 0 && uni < 0 || home < 0 && uni > 0) {
        count++;
      }
    }
    System.out.println(count);
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
    new C284().run();
  }
}