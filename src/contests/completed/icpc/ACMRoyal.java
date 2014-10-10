package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ACMRoyal {
  public void solve() throws IOException {
    int n = nextInt();
    Clerk[] clerks = new Clerk[n];
    for (int x = 0; x < n; x++)
      clerks[x] = new Clerk();

    for (int x = 0; x < n; x++) {
      int clerknum = nextInt() - 1;
      int numchild = nextInt();
      int[] children = new int[numchild];
      for (int y = 0; y < numchild; y++) {
        children[y] = nextInt() - 1;
        clerks[children[y]].setParent(clerknum);
      }
      clerks[clerknum].setChildren(children);
    }

    int pairs = 0;
    boolean done;
    do {
      done = true;
      for (int x = 0; x < n; x++) {
        if (clerks[x] != null && !clerks[x].hasChildren() && clerks[x].parent != -1) {
          pairs++;
          clerks[clerks[x].parent] = null;
          removeParent(clerks, clerks[x].parent);
          clerks[x] = null;
          done = false;
        }
      }
    } while (!done);

    System.out.println(pairs);
  }

  public void removeParent(Clerk[] clerks, int index) {
    for (int x = 0; x < clerks.length; x++) {
      if (clerks[x] != null && clerks[x].parent == index)
        clerks[x].setParent(-1);
      if (clerks[x] != null)
        clerks[x].removeChild(index);
    }
  }

  public class Clerk {
    public int parent = -1;
    public ArrayList<Integer> children = new ArrayList<Integer>();

    public Clerk() {

    }

    public void setChildren(int[] a) {
      for (int x = 0; x < a.length; x++)
        children.add(a[x]);
    }

    public boolean hasChildren() {
      return children.size() != 0;
    }

    public void setParent(int a) {
      parent = a;
    }

    public void removeChild(int a) {
      children.remove(new Integer(a));
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
    new ACMRoyal().run();
  }
}
