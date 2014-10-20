package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A274 {
  class Test implements Comparable<Test> {
    public int a;
    public int b;
    
    public Test(int a, int b) {
      this.a = a;
      this.b = b;
    }
    
    public int compareTo(Test test) {
      if (a == test.a) {
        return b - test.b;
      } else {
        return a - test.a;
      }
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    Test[] tests = new Test[n];
    
    for (int x = 0; x < n; x++) {
      tests[x] = new Test(nextInt(), nextInt());
    }
    Arrays.sort(tests);
    
    int day = 1;
    for (int x = 0; x < n; x++) {
      if (tests[x].b >= day) {
        day = tests[x].b;
      } else {
        day = tests[x].a;
      }
    }
    System.out.println(day);
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
    new A274().run();
  }
}
