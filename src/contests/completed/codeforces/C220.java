package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C220 {
  int[][] count;
  char[][] arr;

  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    arr = new char[n][m];
    count = new int[n][m];
    for (int x = 0; x < n; x++)
      arr[x] = nextLine().toCharArray();
    int max = 0;
    for (int x = 0; x < n; x++)
      for (int y = 0; y < m; y++)
        if (arr[x][y] == 'D')
          max = recurse(x, y, nextLetter('D'));
    System.out.println(max);
  }

  public char nextLetter(char a) {
    if (a == 'D')
      return 'I';
    if (a == 'I')
      return 'M';
    if (a == 'M')
      return 'A';
    if (a == 'A')
      return 'D';
    return '\0';
  }

  public int recurse(int x, int y, char next) {
    if (count[x][y] != 0)
      return count[x][y];
    int add = 0;
    if (next == 'D')
      add = 1;
    int max = 0;
    if (x < arr.length - 1 && arr[x + 1][y] == next)
      max = Math.max(max, add + recurse(x + 1, y, nextLetter(next)));
    if (y < arr[0].length - 1 && arr[x][y + 1] == next)
      max = Math.max(max, add + recurse(x, y + 1, nextLetter(next)));
    if (x > 0 && arr[x - 1][y] == next)
      max = Math.max(max, add + recurse(x - 1, y, nextLetter(next)));
    if (y > 0 && arr[x][y - 1] == next)
      max = Math.max(max, add + recurse(x, y - 1, nextLetter(next)));
    return max;
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
    new C220().run();
  }
}
