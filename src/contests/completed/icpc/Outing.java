package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Outing {
  
  static class Component {
    private Set<Integer> visited;
    private Set<Integer> center;
    
    public Component(Set<Integer> center, Set<Integer> visited) {
      this.center = center;
      this.visited = visited;
    }
    
    public void addVisited(Set<Integer> visit) {
      visited.addAll(visit);
    }
    
    public boolean sameCenter(Set<Integer> cent) {
      return center.equals(cent);
    }
    
    public int centerSize() {
      return center.size();
    }
    
    public int maxSize() {
      return visited.size();
    }
  }
  
  public Component getComponent(Set<Component> components, Set<Integer> center) {
    for (Component component : components) {
      if (component.sameCenter(center)) 
        return component;
    }
    return null;
  }
  
  
  public void solve() throws IOException {
    int n = nextInt();
    int k = nextInt();
    int[] edges = new int[n];
    for (int x = 0; x < n; x++) {
      edges[x] = nextInt() - 1;
    }
    Set<Integer> visited = new HashSet<Integer>();
    Set<Component> components = new HashSet<Component>();
    for (int x = 0; x < n; x++) {
      if (!visited.contains(x)) {
        //System.out.println(x);
        Set<Integer> inpath = new HashSet<Integer>();
        List<Integer> path = new ArrayList<Integer>();
        
        int next = x;
        while (!inpath.contains(next)) {
          path.add(next);
          inpath.add(next);
          next = edges[next];
        }
        
        Set<Integer> center = new HashSet<Integer>();
        while (!center.contains(next)) {
          center.add(next);
          next = edges[next];
        }
        
        Component component = getComponent(components, center);
        if (component != null) {
          component.addVisited(inpath);
        } else {
          components.add(new Component(center, inpath));
        }
        
        visited.addAll(inpath);
      }
    }
    
    boolean[] dp = new boolean[k + 1];
    dp[0] = true;
    
    for (Component component : components) {
      boolean[] newdp = new boolean[k + 1];
      for (int x = 0; x < k + 1; x++) {
        if (dp[x]) {
          newdp[x] = true;
          for (int y = component.centerSize(); y <= component.maxSize(); y++) {
            if (x + y <= k) {
              newdp[x + y] = true;
              if (x + y == k) {
                System.out.println(k);
                return;
              }
            }
          }
        }
      }
      dp = newdp;
    }
    for (int x = k; x >= 0; x--) {
      if (dp[x]) {
        System.out.println(x);
        return;
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
    new Outing().run();
  }
}
