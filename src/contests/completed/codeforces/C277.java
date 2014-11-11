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

public class C277 {

  public void solve() throws IOException {
    int n = nextInt();
    int p = nextInt() - 1;
    String input = nextLine();

    List<Integer> changes = new ArrayList<Integer>();
    for (int x = 0; x < n/2; x++) {
      if (input.charAt(x) != input.charAt(n - x - 1)) {
        changes.add(x);
      }
    }
    
    p = Math.min(p, n - 1 - p);
    if (changes.size() == 0) {
      System.out.println(0);
    } else {
      long moves = Math.min(Math.abs(p - changes.get(0)), 
          Math.abs(p - changes.get(changes.size() - 1)));
      if (changes.size() > 1) {
        moves += Math.abs(changes.get(0) - changes.get(changes.size() - 1));
      }
      for (int x = 0; x < changes.size(); x++) {
        moves += mindiff(input.charAt(changes.get(x)), input.charAt(n - 1 - changes.get(x)));
      }
      System.out.println(moves);
    }
  }

  public int mindiff(char a, char b) {
    int min = Math.min(a, b);
    int max = Math.max(a, b);

    return Math.min(max - min, (min - max + 26) % 26);
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
    new C277().run();
  }
}
