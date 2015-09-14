package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C307 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    
    int mintime = 0;
    int maxtime = 0;
    
    int[] boxes = new int[n];
    boolean zero = true;
    for (int x = 0; x < n; x++) {
      maxtime++;
      
      boxes[x] = nextInt();
      maxtime += Math.ceil((double)boxes[x] / m);
      zero &= (boxes[x] == 0);
    }
    
    if (zero) {
      System.out.println(0);
      return;
    }
    
    while (maxtime > mintime + 1) {
      int middle = (maxtime + mintime) / 2;
      int students = m;
      boolean possible = true;
      int[] add = new int[n];
      for (int x = 0; x < n; x++) {
        int time = x + 1;
        if (boxes[x] > 0) {
          int remaining = middle - time;
          int minimum = (int) Math.ceil((double)boxes[x] / students);
          if (remaining < minimum) {
            possible = false;
          } else {
            int left = (int) Math.ceil((double)boxes[x] / remaining);
            students -= left;
          }
        }
      }
      if (possible) {
        maxtime = middle;
      } else {
        mintime = middle;
      }
    }
    System.out.println(maxtime);
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
    new C307().run();
  }
}
