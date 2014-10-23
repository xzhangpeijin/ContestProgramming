package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class KlingtonWarfare {
  
  private class WarriorPairs {
    public List<Warrior> mWarriors;
    public List<Warrior> nWarriors;

    public WarriorPairs() {
      this.mWarriors = new ArrayList<Warrior>();
      this.nWarriors = new ArrayList<Warrior>();
    }
  }

  private class Warrior {
    public char style;
    public List<Warrior> subs;
    public int size;

    public Warrior(char style) {
      this.style = style;
      this.subs = new ArrayList<Warrior>();
      this.size = 1;
    }
    
    public void updateSize() {
      this.size = 1;
      for (Warrior warrior : subs) {
        this.size += warrior.size;
      }
    }
  }

  private HashMap<Integer, WarriorPairs> map = new HashMap<Integer, WarriorPairs>();

  private HashMap<Warrior, Set<Warrior>> mMatch = new HashMap<Warrior, Set<Warrior>>(); 
  private HashMap<Warrior, Set<Warrior>> mNotMatch = new HashMap<Warrior, Set<Warrior>>(); 
  private HashMap<Warrior, Set<Warrior>> nMatch = new HashMap<Warrior, Set<Warrior>>(); 
  private HashMap<Warrior, Set<Warrior>> nNotMatch = new HashMap<Warrior, Set<Warrior>>(); 

  public void solve() throws IOException {
    int t = nextInt();
    for (int i = 0; i < t; i++) {
      map.clear();
      mMatch.clear();
      mNotMatch.clear();
      nMatch.clear();
      nNotMatch.clear();

      int m = nextInt();
      int n = nextInt();

      Warrior[] mWarriors = new Warrior[m];
      Warrior[] nWarriors = new Warrior[n];

      for (int x = 0; x < m; x++) {
        mWarriors[x] = new Warrior(nextToken().charAt(0));
        int superior = nextInt();
        if (superior != -1) {
          mWarriors[superior].subs.add(mWarriors[x]);
        }
      }
      
      for (int x = mWarriors.length - 1; x >= 0; x--) {
        mWarriors[x].updateSize();
      }

      for (int x = 0; x < n; x++) {
        nWarriors[x] = new Warrior(nextToken().charAt(0));
        int superior = nextInt();
        if (superior != -1) {
          nWarriors[superior].subs.add(nWarriors[x]);
        }
      }
      
      for (int x = nWarriors.length - 1; x >= 0; x--) {
        nWarriors[x].updateSize();
      }

      for (int x = 0; x < mWarriors.length; x++) {
        int size = mWarriors[x].size;
        if (!map.containsKey(size)) {
          map.put(size, new WarriorPairs());
        }
        map.get(size).mWarriors.add(mWarriors[x]);
      }

      for (int x = 0; x < nWarriors.length; x++) {
        int size = nWarriors[x].size;
        if (!map.containsKey(size)) {
          map.put(size, new WarriorPairs());
        }
        map.get(size).nWarriors.add(nWarriors[x]);
      }

      List<Integer> sizes = new ArrayList<Integer>(map.keySet());
      Collections.sort(sizes, Collections.reverseOrder());
      
      search: {
        for (int size : sizes) {
          WarriorPairs pairs = map.get(size);
          for (int x = 0; x < pairs.mWarriors.size(); x++) {
            for (int y = 0; y < pairs.nWarriors.size(); y++) {
              if (match(pairs.mWarriors.get(x), pairs.nWarriors.get(y))) {
                System.out.println(size);
                break search;
              }
            }
          }
        }
        System.out.println(0);
      }
    }
  }

  public boolean match(Warrior m, Warrior n) {
    if (mMatch.containsKey(m) && mMatch.get(m).contains(n)) {
      return true;
    } else if (nMatch.containsKey(n) && nMatch.get(n).contains(m)) {
      return true;
    } else if (mNotMatch.containsKey(m) && mNotMatch.get(m).contains(n)) {
      return false;
    } else if (nNotMatch.containsKey(n) && nNotMatch.get(n).contains(m)) {
      return false;
    }

    if (m.style != n.style || m.subs.size() != n.subs.size() || m.size != n.size) {
      addNotMatch(m, n);
      return false;
    }

    for (int x = 0; x < m.subs.size(); x++) {
      if (!match(m.subs.get(x), n.subs.get(x))) {
        addNotMatch(m.subs.get(x), n.subs.get(x));
        return false;
      } else {
        addMatch(m.subs.get(x), n.subs.get(x));
      }
    }
    addMatch(m, n);
    return true;
  }

  public void addNotMatch(Warrior m, Warrior n) {
    if (!mNotMatch.containsKey(m)) {
      mNotMatch.put(m, new HashSet<Warrior>());
    }
    mNotMatch.get(m).add(n);
    if (!nNotMatch.containsKey(n)) {
      nNotMatch.put(n, new HashSet<Warrior>());
    }
    nNotMatch.get(n).add(m);
  }

  public void addMatch(Warrior m, Warrior n) {
    if (!mMatch.containsKey(m)) {
      mMatch.put(m, new HashSet<Warrior>());
    }
    mMatch.get(m).add(n);
    if (!nMatch.containsKey(n)) {
      nMatch.put(n, new HashSet<Warrior>());
    }
    nMatch.get(n).add(m);
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
    new KlingtonWarfare().run();
  }
}
