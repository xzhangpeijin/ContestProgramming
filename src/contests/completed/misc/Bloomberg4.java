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

public class Bloomberg4 {
  
  private static class Letter implements Comparable<Letter> {
    String c;
    int value;
    public Letter(String c, int value) {
      this.c = c;
      this.value = value;
    }
    @Override
    public int compareTo(Letter o) {
      return o.value - value;
    }
  }
  
  public boolean isVowel(String a) {
    return a.equals("A") || a.equals("E") || a.equals("I") || a.equals("O") || a.equals("U");
  }
  
  public void solve() throws IOException {
    List<Letter> odd = new ArrayList<Letter>();
    List<Letter> even = new ArrayList<Letter>();
    List<Letter> oddvowels = new ArrayList<Letter>();
    List<Letter> evenvowels = new ArrayList<Letter>();

    
    String[] data = nextLine().split(" ");
    for (int x = 0; x < data.length; x += 2) {
      int value = Integer.parseInt(data[x + 1]);
      if (value % 2 == 0) {
        even.add(new Letter(data[x], value));
      } else {
        odd.add(new Letter(data[x], value));
      }
      
      if (isVowel(data[x])) {
        if (value % 2 == 0) {
          evenvowels.add(new Letter(data[x], value));
        } else {
          evenvowels.add(new Letter(data[x], value));
        }
      }
    }
    
    Collections.sort(odd);
    Collections.sort(even);
    Collections.sort(oddvowels);
    Collections.sort(evenvowels);
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
    new Bloomberg4().run();
  }
}
