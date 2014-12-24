package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A284 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int x = nextInt();
    
    boolean[] interesting = new boolean[100000];
    
    for (int i = 0; i < n; i++) {
      int start = nextInt() - 1;
      int end = nextInt() - 1;
      for (int j = start; j <= end; j++) {
        interesting[j] = true;
      }
    }
    
    int watched = 0;
    int consecutive = 0;
    for (int i = 0; i < 100000; i++) {
      watched++;
      if (interesting[i]) {
        consecutive = 0;
      } else {
        consecutive++;
      }
      if (consecutive == x) {
        consecutive = 0;
        watched -= x;
      }
    }
    watched -= consecutive;
    System.out.println(watched);
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
    new A284().run();
  }
}
