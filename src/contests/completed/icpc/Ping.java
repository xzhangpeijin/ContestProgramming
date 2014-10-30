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

public class Ping {
  
  public void solve() throws IOException {
    String nextline;
    while (!(nextline = nextLine()).equals("0")) {
      List<Integer> satellites = new ArrayList<Integer>();
      for (int x = 1; x < nextline.length(); x++) {
        if (getChar(satellites, x) != nextline.charAt(x)) {
          satellites.add(x);
        }
      }
      StringBuffer buf = new StringBuffer();
      for (int x = 0; x < satellites.size(); x++) {
        if (x != 0) 
          buf.append(" ");
        buf.append(satellites.get(x));
      }
      System.out.println(buf.toString());
    }
  }
  
  public char getChar(List<Integer> satellites, int pos) {
    int count = 0;
    for (int x = 0; x < satellites.size(); x++) {
      if (pos % satellites.get(x) == 0) {
        count++;
      }
    }
    if (count % 2 == 0) {
      return '0';
    } else {
      return '1';
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
    new Ping().run();
  }
}
