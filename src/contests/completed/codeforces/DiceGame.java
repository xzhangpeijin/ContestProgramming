package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiceGame {
  
  public void solve() throws IOException {
    int a1 = nextInt();
    int b1 = nextInt();
    int a2 = nextInt();
    int b2 = nextInt();
    
    double gunnar = (double)(a1 + b1) / 2 + (double)(a2 + b2) / 2;
    
    a1 = nextInt();
    b1 = nextInt();
    a2 = nextInt();
    b2 = nextInt();
    
    double emma = (double)(a1 + b1) / 2 + (double)(a2 + b2) / 2;
    
    if (gunnar > emma) {
      System.out.println("Gunnar");
    } else if (gunnar == emma) {
      System.out.println("Tie");
    } else {
      System.out.println("Emma");
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
    new DiceGame().run();
  }
}
