package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B269 {
  class Entry implements Comparable<Entry> {
    public int value;
    public int index;

    public Entry(int value, int index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Entry entry) {
      return value - entry.value;
    }
  }

  public void solve() throws IOException {
    int tasks = nextInt();
    Entry[] diff = new Entry[tasks];
    for (int x = 0; x < tasks; x++) {
      diff[x] = new Entry(nextInt(), x + 1);
    }
    Arrays.sort(diff);

    int firstindex = -1;
    boolean matchprev = false;
    for (int x = 0; x < tasks; x++) {
      if (x != 0 && diff[x].value == diff[x - 1].value) {
        if (matchprev) {
          System.out.println("YES");
          for (int y = 0; y < tasks; y++) {
            if (y != tasks - 1) {
              System.out.print(diff[y].index + " ");
            } else {
              System.out.println(diff[y].index);
            }
          }

          for (int y = 0; y < tasks; y++) {
            int toprint = y;
            if (y == x - 1) {
              toprint = x;
            } else if (y == x) {
              toprint = x - 1;
            }
            if (y != tasks - 1) {
              System.out.print(diff[toprint].index + " ");
            } else {
              System.out.println(diff[toprint].index);
            }
          }

          for (int y = 0; y < tasks; y++) {
            int toprint = y;
            if (y == x - 2) {
              toprint = x - 1;
            } else if (y == x - 1) {
              toprint = x - 2;
            }
            if (y != tasks - 1) {
              System.out.print(diff[toprint].index + " ");
            } else {
              System.out.println(diff[toprint].index);
            }
          }
          return;
        } else if (firstindex != -1) {
          System.out.println("YES");
          for (int y = 0; y < tasks; y++) {
            if (y != tasks - 1) {
              System.out.print(diff[y].index + " ");
            } else {
              System.out.println(diff[y].index);
            }
          }
          for (int y = 0; y < tasks; y++) {
            int toprint = y;
            if (y == x - 1) {
              toprint = x;
            } else if (y == x) {
              toprint = x - 1;
            }
            if (y != tasks - 1) {
              System.out.print(diff[toprint].index + " ");
            } else {
              System.out.println(diff[toprint].index);
            }
          }
          for (int y = 0; y < tasks; y++) {
            int toprint = y;
            if (y == firstindex) {
              toprint = firstindex - 1;
            } else if (y == firstindex - 1) {
              toprint = firstindex;
            }
            if (y != tasks - 1) {
              System.out.print(diff[toprint].index + " ");
            } else {
              System.out.println(diff[toprint].index);
            }
          }
          return;
        }

        matchprev = true;
        firstindex = x;
      } else {
        matchprev = false;
      }
    }
    System.out.println("NO");
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
    new B269().run();
  }
}
