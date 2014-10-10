package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C261 {
  public void solve() throws IOException {
    int n = nextInt();
    int k = nextInt();
    int d = nextInt();

    if (k >= n) {
      for (int x = 0; x < d; x++) {
        for (int y = 1; y < n; y++) {
          System.out.print(y + " ");
        }
        System.out.println(n);
      }
      return;
    }

    if (n > Math.pow(k, d)) {
      System.out.println(-1);
      return;
    }

    ArrayList<ArrayList<Integer>> completed = new ArrayList<ArrayList<Integer>>();
    Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();
    queue.add(new ArrayList<Integer>());

    while (completed.size() < n) {
      ArrayList<Integer> cur = queue.poll();
      for (int x = 1; x <= k; x++) {
        if (queue.size() == n - 1) {
          cur.add(x);
          if (cur.size() == d) {
            completed.add(cur);
          } else {
            queue.add(cur);
          }
          break;
        } else {
          ArrayList<Integer> newlist = new ArrayList<Integer>(cur);
          newlist.add(x);
          if (newlist.size() == d) {
            completed.add(newlist);
          } else {
            queue.add(newlist);
          }
        }
      }
    }

    for (int x = 0; x < d; x++) {
      for (int y = 0; y < n; y++) {
        if (y != n - 1) {
          System.out.print(completed.get(y).get(x) + " ");
        } else {
          System.out.println(completed.get(y).get(x));
        }
      }
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
    new C261().run();
  }
}
