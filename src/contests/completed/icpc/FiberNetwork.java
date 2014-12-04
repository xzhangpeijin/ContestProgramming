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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class FiberNetwork {
  static class Graph {
    private Map<Integer, List<Integer>> graph;
    private Set<Integer>[] reachable;
    
    @SuppressWarnings("unchecked")
    public Graph(int n) {
      this.graph = new HashMap<Integer, List<Integer>>(n);
      this.reachable = new HashSet[n];
      for (int x = 0; x < n; x++) {
        this.graph.put(x, new ArrayList<Integer>());
      }
    }
    
    public void addEdge(int start, int end) {
      this.graph.get(start).add(end);
    }
    
    public void process() {
      for (int node : graph.keySet()) {
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> search = new LinkedList<Integer>();
        visited.add(node);
        search.add(node);
        
        while (search.size() > 0) {
          int cur = search.poll();
          for (int next : graph.get(cur)) {
            if (reachable[next] != null) {
              visited.addAll(reachable[next]);
            } else if (!visited.contains(next)) {
              visited.add(next);
              search.add(next);
            }
          }
        }
        
        reachable[node] = visited;
      }
    }
    
    public boolean search(int start, int end) {
      if (reachable[start] != null) {
        return reachable[start].contains(end);
      } else {
        System.out.println("null");
        return false;
      }
    }
  }
  
  public void solve() throws IOException {
    int n;
    while ((n = nextInt()) != 0) {
      HashMap<Character, Graph> networks = new HashMap<Character, Graph>();
      String nextline;
      while (!(nextline = nextLine()).equals("0 0")) {
        StringTokenizer t = new StringTokenizer(nextline);
        int a = Integer.parseInt(t.nextToken());
        int b = Integer.parseInt(t.nextToken());
        String companies = t.nextToken();
        for (int x = 0; x < companies.length(); x++) {
          Character company = companies.charAt(x);
          if (!networks.containsKey(company)) {
            networks.put(company, new Graph(n));
          }
          networks.get(company).addEdge(a - 1, b - 1);
        }
      }
      
      for (Entry<Character, Graph> entry : networks.entrySet()) {
        entry.getValue().process();
      }
      
      while (!(nextline = nextLine()).equals("0 0")) {
        StringTokenizer t = new StringTokenizer(nextline);
        int a = Integer.parseInt(t.nextToken());
        int b = Integer.parseInt(t.nextToken());
        List<Character> ans = new ArrayList<Character>();
        for (Entry<Character, Graph> entry : networks.entrySet()) {
          if (entry.getValue().search(a - 1, b - 1)) {
            ans.add(entry.getKey());
          }
        }
        Collections.sort(ans);
        if (ans.size() > 0) {
          StringBuffer buf = new StringBuffer();
          for (Character company : ans) {
            buf.append(company);
          }
          System.out.println(buf.toString());
        } else {
          System.out.println("-");
        }
      }
      System.out.println();
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
    new FiberNetwork().run();
  }
}
