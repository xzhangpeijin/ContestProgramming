package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ACMDElevator {
  int[] moves;

  public void solve() throws IOException {
    int f = nextInt();
    int s = nextInt() - 1;
    int g = nextInt() - 1;
    int u = nextInt();
    int d = nextInt();
    moves = new int[f];
    for (int x = 0; x < f; x++)
      moves[x] = Integer.MAX_VALUE;
    moves[s] = 0;
    int gcd = new BigInteger(String.valueOf(u)).gcd(new BigInteger(String.valueOf(d))).intValue();
    if ((u == 0 && g > f) || (d == 0 && g < f))
      System.out.println("use the stairs");
    else if ((s - g) % gcd != 0)
      System.out.println("use the stairs");
    else {
      int ans = solve(s, g, f, u, d);
      if (ans == Integer.MAX_VALUE)
        System.out.println("use the stairs");
      else
        System.out.println(ans);
    }
  }

  public int solve(int start, int goal, int floors, int up, int down) {
    if (start >= floors || start < 0)
      return Integer.MAX_VALUE;
    if (start == goal)
      return moves[start];
    int num = moves[start];
    // System.out.println(start + " " + num);
    if (start + up < floors && start - down >= 0 && num + 1 < moves[start + up]
        && num + 1 < moves[start - down]) {
      moves[start + up] = num + 1;
      moves[start - down] = num + 1;
      return Math.min(solve(start + up, goal, floors, up, down),
          solve(start - down, goal, floors, up, down));
    } else if (start + up < floors && num + 1 < moves[start + up]) {
      moves[start + up] = num + 1;
      return solve(start + up, goal, floors, up, down);
    } else if (start - down >= 0 && num + 1 < moves[start - down]) {
      moves[start - down] = num + 1;
      return solve(start - down, goal, floors, up, down);
    } else
      return Integer.MAX_VALUE;
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
    new ACMDElevator().run();
  }
}
