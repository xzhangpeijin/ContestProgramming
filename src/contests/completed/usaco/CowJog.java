package contests.completed.usaco;


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

public class CowJog {
  static class Cow {
    public final long pos, speed;

    public Cow(long pos, long speed) {
      this.pos = pos;
      this.speed = speed;
    }
  }
  
  static class MutableLong implements Comparable<MutableLong> {
    public long val;
    public MutableLong(long val) {
      this.val = val;
    }
    
    public void setVal(long val) {
      this.val = val;
    }

    @Override
    public int compareTo(MutableLong a) {
      return Long.valueOf(val).compareTo(a.val);
    }
  }

  public void solve() throws IOException {
    int n = nextInt();
    long t = nextLong();

    Cow[] cows = new Cow[n];
    for (int x = 0; x < n; x++) {
      cows[x] = new Cow(nextInt(), nextInt());
    }

    List<MutableLong> lanes = new ArrayList<MutableLong>(n);
    for (int x = n - 1; x >= 0; x--) {
      MutableLong end = new MutableLong(cows[x].pos + cows[x].speed * t);
      if (lanes.size() == 0 || lanes.get(lanes.size() - 1).val <= end.val) {
        lanes.add(end);
      } else {
        int index = Collections.binarySearch(lanes, end);
        if (index < 0) {
          index = -1 * (index + 1);
        } else {
          while (lanes.get(index).val == end.val) {
            index++;
          }
        }
        lanes.get(index).setVal(end.val);
      }
    }
    
    out.println(lanes.size());
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
    oj = false;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("cowjog.in")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("cowjog.out"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new CowJog().run();
  }
}
