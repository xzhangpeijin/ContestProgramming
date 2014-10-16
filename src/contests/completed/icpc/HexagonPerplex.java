package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HexagonPerplex {

  class Hexagon {
    int[] vals;
    int index;

    public Hexagon(int[] vals) {
      this.vals = vals;
      this.index = 0;
    }

    public int rotate(int place, int target) {
      int count = 0;
      while (get(place) != target) {
        index++;
        count++;
        index %= 6;
      }
      return count;
    }

    public void reset(int count) {
      index += 6;
      index -= count;
      index %= 6;
    }

    public int get(int i) {
      return vals[(index + i)% 6];
    }
  }

  public void solve() throws IOException {
    int n = nextInt();
    for (int i = 1; i <= n; i++) {
      Hexagon[] hexagons = new Hexagon[7];
      for (int x = 0; x < 7; x++) {
        int[] vals = new int[6];
        for (int y = 0; y < 6; y++) {
          vals[y] = nextInt();
        }
        hexagons[x] = new Hexagon(vals);
      }

      outer : {
        for (int a = 0; a < 7; a++) {
          int acount = hexagons[a].rotate(0, 1);
          for (int b = 0; b < 7; b++) {
            if (a != b) {
              int bcount = hexagons[b].rotate(3, hexagons[a].get(0));
              for (int c = 0; c < 7; c++) {
                if (a != c && b != c) {
                  int ccount = hexagons[c].rotate(5, hexagons[b].get(2));
                  if (hexagons[a].get(1) == hexagons[c].get(4)) {
                    for (int d = 0; d < 7; d++) {
                      if (a != d && b != d && c != d) {
                        int dcount = hexagons[d].rotate(0, hexagons[c].get(3));
                        if (hexagons[a].get(2) == hexagons[d].get(5)) {
                          for (int e = 0; e < 7; e++) {
                            if (a != e && b != e && c != e && d != e) {
                              int ecount = hexagons[e].rotate(1, hexagons[d].get(4));
                              if (hexagons[a].get(3) == hexagons[e].get(0)) {
                                for (int f = 0; f < 7; f++) {
                                  if (a != f && b != f && c != f && d != f && e != f) {
                                    int fcount = hexagons[f].rotate(2, hexagons[e].get(5));
                                    if (hexagons[a].get(4) == hexagons[f].get(1)) {
                                      for (int g = 0; g < 7; g++) {
                                        if (a != g && b != g && c != g && d != g && e != g && f != g) {
                                          int gcount = hexagons[g].rotate(3, hexagons[f].get(0));
                                          if (hexagons[a].get(5) == hexagons[g].get(2) &&
                                              hexagons[b].get(4) == hexagons[g].get(1)) {
                                            System.out.format("Case %d: %d %d %d %d %d %d %d%n", 
                                                i, a, b, c, d, e, f, g);
                                            break outer;
                                          }
                                          hexagons[g].reset(gcount);
                                        }
                                      }
                                    }
                                    hexagons[f].reset(fcount);
                                  }
                                }
                              }
                              hexagons[e].reset(ecount);
                            }
                          }
                        }
                        hexagons[d].reset(dcount);
                      }
                    }
                  }
                  hexagons[c].reset(ccount);
                }
              }
              hexagons[b].reset(bcount);
            }
          }
          hexagons[a].reset(acount);
        }
        System.out.format("Case %d: No solution%n", i);
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
    new HexagonPerplex().run();
  }
}
