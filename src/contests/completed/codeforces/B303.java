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

public class B303 {
  
  public void solve() throws IOException {
    String s = nextLine();
    String t = nextLine();
    List<Integer> diff = new ArrayList<Integer>();
    for (int x = 0; x < s.length(); x++) {
      if (s.charAt(x) != t.charAt(x)) {
        diff.add(x);
      }
    }
    if (diff.size() % 2 != 0) {
      System.out.println("impossible");
    } else {
      char[] p = s.toCharArray();
      for (int x = 0; x < diff.size() / 2; x++) {
        int index = diff.get(x);
        p[index] = (p[index] == '1') ? '0' : '1';
      }
      System.out.println(new String(p));
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
    new B303().run();
  }
}
