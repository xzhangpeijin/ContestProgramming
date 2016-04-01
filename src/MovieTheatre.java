

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MovieTheatre {
  static class Node {
    List<Integer> path;
    double value;
    public Node(List<Integer> path, double value) {
      this.path = path;
      this.value = value;
    }
  }
  
  static String toString(String[] names, List<Integer> path) {
    StringBuilder buf = new StringBuilder();
    for (int val : path) {
      if (buf.length() > 0) {
        buf.append(",");
      }
      buf.append(names[val]);
    }
    return buf.toString();
  }
  
  public void solve() throws IOException {
    String[] data = nextLine().split(";");
    int n = data.length;
    String[] names = new String[n];
    double[][] rel = new double[n][n];
    for (int i = 0; i < n; i++) {
      String[] dat = data[i].split(":");
      names[i] = dat[0];
      String[] val = dat[1].split(",");
      for (int j = 0; j < n; j++) {
        rel[i][j] = Double.parseDouble(val[j]);
      }
    }

    double[][] graph = new double[n][n];
  
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        graph[i][j] = (rel[i][j] + rel[j][i]);
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }
        
    List<Node> search = new ArrayList<Node>();
    for (int i = 0; i < n; i++) {
      List<Integer> path = new ArrayList<Integer>();
      path.add(i);
      search.add(new Node(path, 0));
    }
    
    List<Integer> bestpath = null;
    double maxval = Double.NEGATIVE_INFINITY;
    while (search.size() > 0) {
      Node node = search.remove(search.size() - 1);
      if (node.path.size() == n) {
        if (node.value > maxval || 
            (node.value == maxval && 
              toString(names, node.path).compareTo(
                  toString(names, bestpath)) < 0)) {
          bestpath = node.path;
          maxval = node.value;
        }
      } else {
        for (int i = 0; i < n; i++) {
          if (!node.path.contains(i)) {
            List<Integer> path = new ArrayList<Integer>(node.path);
            path.add(i);
            search.add(new Node(path, node.value + graph[node.path.get(node.path.size() - 1)][i]));
          }
        }
      }
    }
    
    System.out.println(toString(names, bestpath));
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
    new MovieTheatre().run();
  }
}
