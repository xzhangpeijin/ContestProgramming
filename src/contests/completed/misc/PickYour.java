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

public class PickYour {
  class Problem implements Comparable<Problem> {
    double ratio;
    int id, score, time;
    public Problem(int id, int score, int time) {
      this.id = id;
      this.score = score;
      this.time = time;
      this.ratio = (double)score / time;
    }

    @Override
    public int compareTo(Problem o) {
      if (ratio != o.ratio) {
        return Double.compare(ratio, o.ratio);
      }
      return o.score - score;
    }
  }
  
  public void solve() throws IOException {
    int max = nextInt();
    List<Problem> problems = new ArrayList<Problem>();
    String nextline = "";
    while ((nextline = nextLine()) != null && nextline.length() > 0) {
      String[] dat = nextline.split(",");
    }
    Collections.sort(problems);
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
    new PickYour().run();
  }
}
