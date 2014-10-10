package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class C98 {
  public void solve() throws IOException {
    int num = nextInt();
    ArrayList<Event> events = new ArrayList<Event>();
    for (int x = 0; x < num; x++)
      events.add(new Event(nextInt(), nextInt()));

    Collections.sort(events);

    int count = 0;
    int enc = 0;
    for (int x = 1; x < events.size(); x++) {
      if (events.get(enc).end > events.get(x).end)
        count++;
      else {
        while (events.get(enc).end < events.get(x).end)
          enc++;
      }
    }
    System.out.println(count);
  }

  public class Event implements Comparable<Event> {
    public int start;
    public int end;

    public Event(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int compareTo(Event arg0) {
      return start - arg0.start;
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
    new C98().run();
  }
}
