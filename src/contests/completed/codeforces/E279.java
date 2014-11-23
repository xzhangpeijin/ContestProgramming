package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E279 {

  static class Unknown {
    private char[] digits;
    private int finalvalue;
    private int maxvalue;

    public Unknown(String in) {
      this.digits = in.toCharArray();
      char[] max = new char[digits.length];

      boolean free = false;
      for (int x = 0; x < digits.length; x++) {
        if (digits[x] == '?') {
          max[x] = '9';
          free = true;
        } else {
          max[x] = digits[x];
        }
      }
      maxvalue = Integer.parseInt(new String(max));
      
      if (free) {
        finalvalue = -1;
      } else {
        finalvalue = maxvalue;
      }
    }

    public boolean setValue(int min) {
      if (min >= maxvalue) {
        return false;
      }
      
      if (finalvalue != -1) {
        return true;
      }

      char[] target = String.valueOf(min).toCharArray();
      if (target.length < digits.length) {
        for (int x = 0; x < digits.length; x++) {
          if (x == 0 && digits[x] == '?') {
            digits[x] = '1';
          } else if (digits[x] == '?') {
            digits[x] = '0';
          }
        }
        finalvalue = Integer.parseInt(new String(digits));
      } else {
        for (int x = 0; x < digits.length; x++) {
          if (digits[x] != target[x]) {
            if (digits[x] != '?' && digits[x] > target[x]) {
              for (int y = x + 1; y < digits.length; y++) {
                if (digits[y] == '?') {
                  digits[y] = '0';
                }
              }
              finalvalue = Integer.parseInt(new String(digits));
              return true;
            } else if (digits[x] == '?') {
              boolean free = search(digits, target, x + 1);
              if (!free) {
                digits[x] = (char) (target[x] + 1);
                for (int y = x + 1; y < digits.length; y++) {
                  if (digits[y] == '?') {
                    digits[y] = '0';
                  }
                }
                finalvalue = Integer.parseInt(new String(digits));
                return true;
              } else {
                digits[x] = target[x];
              }
            }
          }
        }
      }
      finalvalue = Integer.parseInt(new String(digits));
      return true;
    }
    
    private boolean search(char[] digits, char[] target, int pos) {
      for (int x = pos; x < digits.length; x++) {
        if (digits[x] == '?') {
          if (target[x] == '9') {
            return search(digits, target, pos + 1);
          } else {
            return true;
          }
        } else if (digits[x] > target[x]) {
          return true;
        } else if (target[x] > digits[x]) {
          return false;
        } 
      }
      return false;
    }

    public int getValue() {
      return finalvalue;
    }
  }
  public void solve() throws IOException {
    int n = nextInt();
    Unknown[] values = new Unknown[n];
    for (int x = 0; x < n; x++) {
      values[x] = new Unknown(nextLine());
    }

    int min = 0;
    for (int x = 0; x < n; x++) {
      boolean possible = values[x].setValue(min);
      min = values[x].getValue();
      if (!possible) {
        System.out.println("NO");
        return;
      }
    }
    
    for (int x = 1; x < n; x++) {
      if (values[x].getValue() <= values[x - 1].getValue()) {
        System.out.println("NO");
        return;
      }
    }

    System.out.println("YES");
    for (int x = 0; x < n; x++) {
      System.out.println(values[x].getValue());
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
    new E279().run();
  }
}
