package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Consistent {
  
  private class Employee {
    public int boss = -1;
    public List<Integer> children = new ArrayList<Integer>();
    public int salary = 0;
    public int maxbelow = 0;
    public int minabove = 0;
  }
    
  private Employee[] e;
  
  private void populate(int i) {
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int q = nextInt();
    
    e = new Employee[n];
    
    for (int i = 1; i < n; i++) {
      int boss = nextInt() - 1;
      e[i].boss = boss;
      e[boss].children.add(i);
    }
    
    for (int i = 0; i < n; i++) {
      e[i].salary = nextInt();
    }
    
    populate(0);
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
    new Consistent().run();
  }
}
