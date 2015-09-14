package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B307 {
  
  public void solve() throws IOException {
    String a = nextLine();
    String b = nextLine();
    String c = nextLine();
    
    int[] acount = new int[26];
    for (int x = 0; x < a.length(); x++) {
      acount[a.charAt(x) - 'a']++;
    }
    
    int[] bcount = new int[26];
    for (int x = 0; x < b.length(); x++) {
      bcount[b.charAt(x) - 'a']++;
    }
    
    int[] ccount = new int[26];
    for (int x = 0; x < c.length(); x++) {
      ccount[c.charAt(x) - 'a']++;
    }
    
    int max = 0;
    int maxb = 0;
    int maxc = 0;
    for (int x = 0; x <= a.length() / b.length(); x++) {
      int[] count = new int[26];
      boolean valid = true;
      int min = a.length();
      for (int y = 0; y < 26; y++) {
        count[y] = acount[y] - x * bcount[y];
        if (count[y] < 0) {
          valid = false;
        } else {
          if (ccount[y] != 0) {
            min = Math.min(min, count[y] / ccount[y]);
          }
        }
      }
      if (valid && x + min > max) {
        max = x + min;
        maxb = x;
        maxc = min;
      }
    }
    
    StringBuffer buf = new StringBuffer();
    for (int x = 0; x < maxb; x++) {
      buf.append(b);
    }
    for (int x = 0; x < maxc; x++) {
      buf.append(c);
    }
    for (int x = 0; x < 26; x++) {
      int count = acount[x] - maxb * bcount[x] - maxc * ccount[x];
      for (int y = 0; y < count; y++) {
        buf.append((char)('a' + x));
      }
    }
    System.out.println(buf.toString());
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
    new B307().run();
  }
}
