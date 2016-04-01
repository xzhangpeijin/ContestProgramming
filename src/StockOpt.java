

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StockOpt {
  
  public void solve() throws IOException {
    double maxprofit = 0;
    double min = Double.MAX_VALUE;
    int mintime = -1;
    int buytime = -1;
    int selltime = -1;
    String input = "";
    int time = 0;
    while ((input = nextLine()) != null && input.length() > 0) {
      double price = Double.parseDouble(input);
      if (price < min) {
        min = price;
        mintime = time;
      }
      if (price - min > maxprofit) {
        buytime = mintime;
        selltime = time;
        maxprofit = price - min;
      }
      time++;
    }
    if (maxprofit > 0) {
      System.out.format("Buy: %d%nSell: %d%n", buytime, selltime);
    } else {
      System.out.println("No Profit");
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
    new StockOpt().run();
  }
}
