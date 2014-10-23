package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class CrusherCode {

  public HashMap<String, BigDecimal> montydp = new HashMap<String, BigDecimal>();
  public HashMap<String, BigDecimal> carlodp = new HashMap<String, BigDecimal>();

  public void solve() throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      montydp.clear();
      carlodp.clear();

      int n = nextInt();
      int[] a = new int[n];
      for (int x = 0; x < n; x++) {
        a[x] = nextInt();
      }
      
      BigDecimal monty = runMonty(a);
      BigDecimal carlo = runCarlo(a);
      
      System.out.format("Monty %s Carlos %s%n", 
          monty.setScale(6, BigDecimal.ROUND_HALF_UP).toString(), 
          carlo.setScale(6, BigDecimal.ROUND_HALF_UP).toString());
    }
  }

  class Swap {
    public int start;
    public int end;

    public Swap(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public BigDecimal runMonty(int[] a) {
    String serial = serialize(a);
    if (montydp.containsKey(serial)) {
      return montydp.get(serial);
    }

    List<Swap> swaps = new ArrayList<Swap>();
    for (int x = 0; x < a.length; x++) {
      for (int y = x + 1; y < a.length; y++) {
        if (a[x] > a[y]) {
          swaps.add(new Swap(x, y));
        }
      }
    }
    //System.out.println(swaps.size());
    if (swaps.size() == 0) {
      BigDecimal zero = new BigDecimal(0);
      montydp.put(serial, zero);
      return zero;
    } else {
      BigDecimal expected = new BigDecimal(Math.pow(a.length, 2));
      expected.setScale(100);
      expected = expected.divide(new BigDecimal(2 * swaps.size()), 100, BigDecimal.ROUND_HALF_UP);
      
      for (int x = 0; x < swaps.size(); x++) {
        int[] newa = a.clone();
        swap(newa, swaps.get(x).start, swaps.get(x).end);
        expected = expected.add(runMonty(newa).divide(
            new BigDecimal(swaps.size()), 100, BigDecimal.ROUND_HALF_UP));
      }
      montydp.put(serial, expected);
      return expected;
    }
  }

  public String serialize(int[] a) {
    StringBuffer buf = new StringBuffer();
    for (int x = 0; x < a.length; x++) {
      if (x != 0) 
        buf.append(" ");
      buf.append(a[x]);
    }
    return buf.toString();
  }

  public BigDecimal runCarlo(int[] a) {
    String serial = serialize(a);
    if (carlodp.containsKey(serial)) {
      return carlodp.get(serial);
    }

    List<Swap> swaps = new ArrayList<Swap>();
    for (int x = 0; x < a.length - 1; x++) {
      if (a[x] > a[x + 1]) {
        swaps.add(new Swap(x, x + 1));
      }
    }
    
    if (swaps.size() == 0) {
      BigDecimal zero = new BigDecimal(0);
      carlodp.put(serial, zero);
      return zero;
    } else {
      BigDecimal expected = new BigDecimal(a.length - 1);
      expected.setScale(100);
      expected = expected.divide(new BigDecimal(swaps.size()), 100, BigDecimal.ROUND_HALF_UP);

      for (int x = 0; x < swaps.size(); x++) {
        int[] newa = a.clone();
        swap(newa, swaps.get(x).start, swaps.get(x).end);
        expected = expected.add(runCarlo(newa).divide(
            new BigDecimal(swaps.size()), 100, BigDecimal.ROUND_HALF_UP));
      }
      carlodp.put(serial, expected);
      return expected;
    }
  }

  public void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
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
    new CrusherCode().run();
  }
}
