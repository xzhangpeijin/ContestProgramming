package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WeirdNumbers {
  public void solve() throws IOException {
    String nextline;
    while (!(nextline = nextLine()).equals("end")) {
      String[] line = nextline.split(" ");
      String[] comm = line[0].split("-");

      String number = line[1];
      String command = comm[0];
      int radix = -1 * Integer.parseInt(comm[1]);

      if (command.equals("to")) {
        int num = Integer.parseInt(number);

        StringBuilder ans = new StringBuilder();
        do {
          int mod = num % radix;
          num /= radix;
          if (mod < 0) {
            mod += Math.abs(radix);
            num++;
          }
          ans.insert(0, mod);
        } while (Math.abs(num) > 0);
        System.out.println(ans);
      } else if (command.equals("from")) {
        int total = 0;
        int base = 1;
        for (int x = number.length() - 1; x >= 0; x--) {
          total += (number.charAt(x) - 48) * base;
          base *= radix;
        }
        System.out.println(total);
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
    new WeirdNumbers().run();
  }
}
