package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class C291 {
  static class Count {
    int a, b, c;
    int total;
    
    public Count (String input) {
      a = 0; b = 0; c = 0; total = 0;
      for (int x = 0; x < input.length(); x++) {
        switch (input.charAt(x)) {
          case 'a': a++; total = total * 3; break;
          case 'b': b++; total = total * 3 + 1; break;
          case 'c': c++; total = total * 3 + 2; break;
          default: break;
        }
      }
    }

    public boolean diffOne(Count count) {
      int oneoff = Math.abs(count.a - a) + Math.abs(count.b - b) + Math.abs(count.c - c);
      if (oneoff != 2) {
        return false;
      }
      int diff = Math.abs(total - count.total);
      while (diff % 3 == 0 && diff > 0) {
        diff /= 3;
      }
      return diff == 1 || diff == 2;
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    
    Map<Integer, List<Count>> memory = new HashMap<Integer, List<Count>>();
    for (int x = 0; x < n; x++) {
      String input = nextLine();
      if (!memory.containsKey(input.length())) {
        memory.put(input.length(), new ArrayList<Count>());
      }
      memory.get(input.length()).add(new Count(input));
    }
    
    for (int x = 0; x < m; x++) {
      String test = nextLine();
      boolean found = false;
      if (memory.containsKey(test.length())) {
        Count base = new Count(test);
        for (Count c : memory.get(test.length())) {
          if (c.diffOne(base)) {
            found = true;
            break;
          }
        }
      }
      if (!found) {
        System.out.println("NO");
      } else {
        System.out.println("YES");
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
    new C291().run();
  }
}
