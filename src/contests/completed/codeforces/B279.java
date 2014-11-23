package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Too slow times out
 */
public class B279 {

  static class Info {
    public int before;
    public int after;

    public Info(int before, int after) {
      this.before = before;
      this.after = after;
    }
  }

  public void solve() throws IOException {
    int n = nextInt();

    Info[] people = new Info[n];
    for (int x = 0; x < n; x++) {
      people[x] = new Info(nextInt(), nextInt());
    }


    Set<Integer> used = new HashSet<Integer>();
    used.add(0);
    int[] positions = new int[n];
    int index = 1;
    int tofind = 0;
    while (index < n) {
      for (int x = 0; x < n; x++) {
        if (people[x].before == tofind) {
          positions[index] = people[x].after;
          index += 2;
          tofind = people[x].after;
          used.add(tofind);
          break;
        }
      }
    }

    if (n % 2 == 0) {
      index = n - 2;
      tofind = 0;
      while (index >= 0) {
        for (int x = 0; x < n; x++) {
          if (people[x].after == tofind) {
            positions[index] = people[x].before;
            index -= 2;
            tofind = people[x].before;
            break;
          }
        }
      }
    } else {
      List<Integer> evens = new LinkedList<Integer>();
      while (evens.size() <= n / 2) {
        for (int x = 0; x < n; x++) {
          if (!used.contains(people[x].before) || !used.contains(people[x].after)) {
            if (evens.size() == 0) {
              evens.add(people[x].before);
              evens.add(people[x].after);
              used.add(people[x].before);
              used.add(people[x].after);
            } else if (used.contains(people[x].before)) {
              evens.add(evens.indexOf(people[x].before) + 1, people[x].after);
              used.add(people[x].after);
            } else if (used.contains(people[x].after)) {
              evens.add(evens.indexOf(people[x].after), people[x].before);
              used.add(people[x].before);
            }
          }
        }
      }
      for (int x = 0; x < evens.size(); x++) {
        positions[2 * x] = evens.get(x);
      }
    }
    
    for (int x = 0; x < n; x++) {
      if (x != 0) {
        System.out.print(" ");
      }
      System.out.print(positions[x]);
    }
    System.out.println();
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
    new B279().run();
  }
}
