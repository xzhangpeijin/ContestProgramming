package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ACMHhorror {
  public void solve() throws IOException {
    int n = nextInt();
    int h = nextInt();
    int l = nextInt();

    int[] movies = new int[n];
    for (int x = 0; x < n; x++)
      movies[x] = 1001;
    for (int x = 0; x < h; x++)
      movies[nextInt()] = 0;

    ArrayList<Integer> extra = new ArrayList<Integer>();
    for (int x = 0; x < l; x++) {
      int a = nextInt();
      int b = nextInt();
      if (movies[a] != movies[b] && movies[a] == 0)
        movies[b] = 1;
      else if (movies[a] != movies[b] && movies[b] == 0)
        movies[a] = 1;
      else if (movies[a] != 0 && movies[b] != 0)
        extra.add(10000 * a + b);
    }

    int desired = 1;
    while (extra.size() != 0) {
      // System.out.println(desired + " " + extra.size());
      // for(int x = 0; x < movies.length; x++)
      // System.out.print(movies[x] + " ");
      // System.out.println();
      int size = extra.size();
      for (int x = 0; x < size; x++) {
        int temp = extra.remove(0);
        int a = temp / 10000;
        int b = temp % 10000;

        if (movies[a] != movies[b] && movies[a] == desired)
          movies[b] = desired + 1;
        else if (movies[a] != movies[b] && movies[b] == desired)
          movies[a] = desired + 1;
        else if (movies[a] != desired && movies[b] != desired)
          extra.add(10000 * a + b);
      }
      if (extra.size() == size)
        break;
      desired++;
    }

    int max = 0;
    int index = 0;
    for (int x = 0; x < movies.length; x++) {
      if (movies[x] > max) {
        max = movies[x];
        index = x;
      }
    }
    System.out.println(index);
  }

  public class Movie {
    int ID;
    int HI;

    public Movie(int ID) {
      this.ID = ID;
      this.HI = 1001;
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
    new ACMHhorror().run();
  }
}
