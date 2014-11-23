package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Misread question this is incorrect
 */
public class F279 {

  static class Node {
    public int parent;
    public int population;

    public Node(int population) {
      this.population = population;
      this.parent = -1;
    }

    public void setParent(int parent) {
      this.parent = parent;
    }
  }

  public void solve() throws IOException {
    int n = nextInt();
    Node[] nodes = new Node[n];
    for (int x = 0; x < n; x++) {
      nodes[x] = new Node(nextInt());
    }

    HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

    for (int x = 0; x < n - 1; x++) {
      int a = nextInt();
      int b = nextInt();
      if (nodes[a - 1].population < nodes[b - 1].population) {
        nodes[b - 1].setParent(a - 1);
        if (!graph.containsKey(a - 1)) {
          graph.put(a - 1, new ArrayList<Integer>());
        }
        graph.get(a - 1).add(b - 1);
      } else if (nodes[a - 1].population > nodes[b - 1].population) {
        nodes[a - 1].setParent(b - 1);
        if (!graph.containsKey(b - 1)) {
          graph.put(b - 1, new ArrayList<Integer>());
        }
        graph.get(b - 1).add(a - 1);
      }
    }

    int max = 0;
    for (int x = 0; x < n; x++) {
      if (nodes[x].parent == -1) {
        Set<Integer> frontier = new HashSet<Integer>();
        frontier.add(x);
        int level = 0;
        while (frontier.size() > 0) {
          Set<Integer> newfrontier = new HashSet<Integer>();
          for (int node : frontier) {
            if (graph.containsKey(node)) {
              newfrontier.addAll(graph.get(node));
            }
          }
          level++;
          frontier = newfrontier;
        }
        max = Math.max(max, level);
      }
    }
    System.out.println(max);
  }

  public int dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited) {
    visited.add(start);
    if (graph.containsKey(start)) {
      int max = 0;
      for (int child : graph.get(start)) {
        if (!visited.contains(child)) {
          max = Math.max(max, dfs(graph, child, visited));
        }
      }
      return max + 1;
    } else {
      return 1;
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
    new F279().run();
  }
}
