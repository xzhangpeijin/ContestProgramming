package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Radix {
  int toValue(char a) {
    if (a >= '0' && a <= '9') {
      return a - '0';
    } else {
      return a - 'a' + 10;
    }
  }
  
  char toChar(int val) {
    if (val <= 9) {
      return (char)('0' + val);
    } else {
      return (char)('a' + (val - 10));
    }
  }
  
  public void solve() throws IOException {
    String nextline;
    while ((nextline = nextLine()) != null && nextline.length() > 0) {
      String[] data = nextline.split(",");
      int from = Integer.parseInt(data[1]);
      int to = Integer.parseInt(data[2]);
      boolean valid = true;
      if (from < 2 || from > 36 || to < 2 || to > 36) {
        valid = false;
      }
      String input = data[0].toLowerCase();

      for (char a : input.toCharArray()) {
        if (!Character.isAlphabetic(a) && !Character.isDigit(a)) {
          valid = false;
          break;
        } else if (toValue(a) >= from) {
          valid = false;
          break;
        }
      }
      if (!valid) {
        System.out.println("Invalid Input");
        continue;
      }
      
      int value = 0;
      int base = 1;
      for (int i = input.length() - 1; i >= 0; i--) {
        int val = toValue(input.charAt(i)) * base;
        //System.out.println(input.charAt(i) + " " + val);
        value += val;
        base *= from;
      }
      //System.out.println(value);
      StringBuilder result = new StringBuilder();
      while (value > 0) {
        int mod = value % to;
        result.insert(0, toChar(mod));
        value /= to;
      }
      System.out.println(result.toString());
      //System.out.println();
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
    new Radix().run();
  }
}
