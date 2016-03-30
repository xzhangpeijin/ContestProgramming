package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.lang.Math;

public class ATMWithdrawal {
  
  public void solve() throws IOException {
    
    int tests = nextInt();
    for (int t = 0; t < tests; t++) {
      long w = nextLong();
      if (w % 1000 != 0) {
        System.out.println(0);
        continue;
      }
      
      w /= 1000;
      
      int c = nextInt();
      List<Long> currencies = new ArrayList<Long>(4 * (c + 1));
      for (int i = 0; i <= c; i++) {
        currencies.add((long) (1L * Math.pow(10, i)));
        currencies.add((long) (2L * Math.pow(10, i)));
        currencies.add((long) (3L * Math.pow(10, i)));
        currencies.add((long) (5L * Math.pow(10, i)));
      }
      
      long orig = w;
      
      int notes = 0;
      while (w > 0) {
        int key = Collections.binarySearch(currencies, w);
        if (key >= 0) {
          w = 0;
          notes++;
        } else {
          int ins = -1 * (key + 1);
          long cur = currencies.get(ins - 1);
          notes += w / cur;
          w = w % cur;
        }
      }
      
      long ways = 1;
      for (int i = 0; i < c; i++) {
        if (orig == 0) break;

        int dig = (int) (orig % 10);
        switch (dig) {          
        case 4: 
        case 6:
          ways *= 2;
          break;
         
        case 9:
          ways *= 3;
          break;
        }
        orig /= 10;
      }
            
      if (orig > 10) {
        orig %= 10;
        if (orig < 5) {
          orig += 5;
        }
      }
            
      switch ((int)orig) {          
      case 4: 
      case 6:
        ways *= 2;
        break;
       
      case 9:
        ways *= 3;
        break;
      }

      System.out.println(notes + " " + ways);
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
    new ATMWithdrawal().run();
  }
}
