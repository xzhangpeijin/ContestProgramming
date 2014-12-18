package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Incorrect
public class B283 {
  static class Ans implements Comparable<Ans> {
    public int s, t;
    public Ans(int s, int t) {
      this.s = s;
      this.t = t;
    }
    
    public int compareTo(Ans a) {
      if (s == a.s) {
        return t - a.t;
      } else {
        return s - a.s;
      }
    }
    
    public String toString() {
      return s + " " + t;
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int[] pcount = new int[n];
    int[] gcount = new int[n];
    int last = 1;
    List<Integer> candidates = new ArrayList<Integer>();
    for (int x = 0; x < n; x++) {
      int val = nextInt();
      if (x != 0) {
        pcount[x] = pcount[x - 1];
      }
      if (val == 1) {
        pcount[x]++;
      }
      gcount[x] = x + 1 - pcount[x];
      
      if ((x + 1) % 2 != 0 || pcount[x] != (x + 1) / 2) {
        candidates.add(x);
      }
      
      if (x == n - 1) {
        last = val;
      }
    }
    
    TreeSet<Ans> answers = new TreeSet<Ans>();
    
    for (int cutoff : candidates) {
      //System.out.println(cutoff);
      boolean pwon = pcount[cutoff] > gcount[cutoff];
      int t = (pwon) ? pcount[cutoff] : gcount[cutoff];
      int pwins = 0;
      int gwins = 0;
      
      int cut = cutoff;
      while (cut < n) {
        if (pwon) {
          pwins++;
        } else {
          gwins++;
        }        
        //System.out.println(cut + " " + pwins + " " + gwins);

        if (cut == n - 1) {
          if ((gwins > pwins && last == 2) || (pwins > gwins && last == 1)) {
            //System.out.println(cutoff);
            answers.add(new Ans(Math.max(gwins, pwins), t));
          }
          break;
        }
        
        if (cut + t >= n) break;
        
        int pnext = Arrays.binarySearch(pcount, cut + t, n, pcount[cut] + t);
        int gnext = Arrays.binarySearch(gcount, cut + t, n, gcount[cut] + t);
        
        if (pnext > 0) {
          while (pnext > 0 && pcount[pnext] == pcount[pnext - 1]) {
            pnext--;
          }
        }
        
        if (gnext > 0) {
          while (gnext > 0 && gcount[gnext] == gcount[gnext - 1]) {
            gnext--;
          }
        }
        
        if (gnext < 0 && pnext < 0) {
          break;
        } else if (gnext >= 0 && pnext >= 0) {
          pwon = pnext < gnext;
          cut = Math.min(gnext, pnext);
        } else if (pnext >= 0) {
          pwon = true;
          cut = pnext;
        } else {
          pwon = false;
          cut = gnext;
        }
      }
    }
    
    System.out.println(answers.size());
    for (Ans ans : answers) {
      System.out.println(ans.toString());
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
    new B283().run();
  }
}
