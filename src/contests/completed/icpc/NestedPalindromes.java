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

public class NestedPalindromes {

  public void solve() throws IOException {
    long k;
    while ((k = nextLong()) != 0) {
      boolean valid = true;
      List<Integer> freespots = new ArrayList<Integer>();

      String nextline = nextLine();
      char[] input = nextline.toCharArray();
      int length = input.length;
      int[] values = null;
      search: {
        if ((length & (length + 1)) != 0 || input[0] == '0') {
          valid = false;
        } else {
          while (length > 1) {
            for (int x = 0; x < length / 2; x++) {
              if (input[x] == '?' && input[length - 1 - x] != '?') {
                input[x] = input[length - 1 - x];
              } else if (input[x] != '?' && input[length - 1 - x] == '?') {
                input[length - 1 - x] = input[x];
              } else if (input[x] != input[length - 1 - x]) {
                valid = false;
                break search;
              }
            }
            length /= 2;
            if (input[length] == '?') {
              freespots.add(0, length);
            }
          }
          if (input[0] == '?') {
            freespots.add(0, 0);
          }

          k -= 1;
          values = new int[freespots.size()];
          int index = values.length - 1;
          if (index < 0 && k > 0) {
            valid = false;
            break search;
          }
          while (k > 0) {
            values[index] = (int)(k % 9);
            k /= 9;
            index--;
            if (index < 0 && k > 0) {
              valid = false;
              break search;
            }
          }
        }
      }

      if (!valid) {
        System.out.println(-1);
      } else {
        List<Integer> ints = new ArrayList<Integer>();
        for (int x = 1; x <= 9; x++) {
          ints.add(x);
        }

        if (freespots.contains(0)) {
          for (int x = 2; x < input.length; x *= 2) {
            if (input[x - 1] != '?') {
              ints.remove(new Integer(input[x - 1] - 48));
            }
          }
          if (values[0] < ints.size()) {
            input[0] = (char)(ints.remove(values[0]) + 48);
            ints.clear();
            for (int x = 0; x < 10; x++) {
              if (x != (input[0] - 48)) 
                ints.add(x);
            }
          } else {
            input = "-1".toCharArray();
          }
        } else {
          ints.remove(new Integer(input[0] - 48));
          ints.add(0, 0);
        }
        if (input[0] != '-') {
          for (int x = 1; x < input.length; x *= 2) {
            int mult = x * 2;
            if (x != 1 && freespots.contains(x - 1)) {
              int index = freespots.indexOf(x - 1);
              for (int y = 0; y * mult + x - 1 < input.length; y++) {
                input[mult * y + x - 1] = (char)(ints.get(values[index]) + 48);
              }
            } else {
              for (int y = 0; y * mult + x - 1 < input.length; y++) {
                input[mult * y + x - 1] = input[x - 1];
              }
            }
          }
        }
        System.out.println(new String(input));
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
    new NestedPalindromes().run();
  }
}
