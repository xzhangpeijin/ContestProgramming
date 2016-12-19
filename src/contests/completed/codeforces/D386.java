package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D386 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int k = nextInt();
    int a = nextInt();
    int b = nextInt();
    
    char achar = 'G';
    char bchar = 'B';
    if (b < a) {
      int tmp = a;
      a = b;
      b = tmp;
      achar = 'B';
      bchar = 'G';
    }
        
    int mina = b / k + ((b % k == 0) ? -1 : 0);
    if (a < mina) {
      System.out.println("NO");
      return;
    }
    
    int extra = a - mina;
    
    boolean useb = true;
    int consec = 0;
    
    StringBuilder ans = new StringBuilder(n);
    for (int i = 0; i < n; i++) {
      if (useb) {
        ans.append(bchar);
        b--;
      } else {
        ans.append(achar);
        if (consec > 0) {
          extra--;
        }
        a--;
      }
      consec++;
      if (consec == k || (!useb && extra <= 0) || 
          (useb && b == 0) || (!useb && a == 0)) {
        consec = 0;
        useb = !useb;
      }
    }
    System.out.println(ans);
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
    new D386().run();
  }
}
