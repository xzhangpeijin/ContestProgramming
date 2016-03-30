package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bloomberg3 {
  
  public void solve() throws IOException {
    List<Integer> odd = new ArrayList<Integer>();
    List<Integer> even = new ArrayList<Integer>();
    
    String[] data = nextLine().split(" ");
    for (int x = 0; x < data.length; x += 2) {
      int value = Integer.parseInt(data[x + 1]);
      if (value % 2 == 0) {
        even.add(value);
      } else {
        odd.add(value);
      }
    }
    
    Collections.sort(odd);
    Collections.sort(even);
    int len = Math.min(4, Math.min(odd.size(), even.size()));
    int total = 0;
    for (int x = 1; x <= len; x++) {
      total += odd.get(odd.size() - x);
      total += even.get(even.size() - x);
    }
    if (odd.size() > len && len < 4) {
      total += odd.get(odd.size() - len - 1);
    }
    System.out.println(total);
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
    new Bloomberg3().run();
  }
}
