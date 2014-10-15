

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FlashMob {
  
  class Member {
    public int xco;
    public int yco;
    public Member(int xco, int yco) {
      this.xco = xco;
      this.yco = yco;
    }
  }
  
  public static final Comparator<Member> XCOMP = new Comparator<Member>() {
    @Override
    public int compare(Member arg0, Member arg1) {
      return arg1.xco - arg0.xco;
    }
  };
  
  public static final Comparator<Member> YCOMP = new Comparator<Member>() {
    @Override
    public int compare(Member arg0, Member arg1) {
      return arg1.yco - arg0.yco;
    }
  };
  
  public void solve() throws IOException {
    int n;
    int num = 1;
    while ((n = nextInt()) != 0) {
      Member[] members = new Member[n];
      for (int x = 0; x < n; x++) {
        members[x] = new Member(nextInt(), nextInt());
      }
      Arrays.sort(members, XCOMP);
      int xco = members[n/2].xco;
      Arrays.sort(members, YCOMP);
      int yco = members[n/2].yco;
      
      long total = 0;
      for (int x = 0; x < n; x++) {
        total += Math.abs(members[x].xco - xco);
        total += Math.abs(members[x].yco - yco);
      }
      System.out.format("Case %d: (%d,%d) %d%n", num, xco, yco, total);
      num++;
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
    new FlashMob().run();
  }
}
