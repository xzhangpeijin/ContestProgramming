package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ColorGrid {
  
  class Move {
    final boolean row;
    final int index;
    final int color;
    
    public Move(boolean row, int index, int color) {
      this.row = row;
      this.index = index;
      this.color = color;
    }
  }
  
  class Node {
    Node next = null;
    Node prev = null;
    Move move = null;
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    int p = nextInt();
    
    HashMap<Integer, Node> rowmap = new HashMap<Integer, Node>(n);
    HashMap<Integer, Node> colmap = new HashMap<Integer, Node>(n);
    
    Node head = new Node();
    Node tail = new Node();
    head.next = tail;
    tail.prev = head;
    
    for (int i = 0; i < p; i++) {
      String type = nextToken();
      int index = nextInt() - 1;
      int color = nextInt();
      
      Move move = new Move(type.equals("ROW"), index, color);
      
      Node cur = new Node();
      cur.move = move;
      cur.prev = tail;
      tail.next = cur;
      tail = cur;
      
      Node remove = null;
      if (move.row) {
        if (rowmap.containsKey(index)) {
          remove = rowmap.get(index);
        }
        rowmap.put(index, cur);
      } else {
        if (colmap.containsKey(index)) {
          remove = colmap.get(index);
        }
        colmap.put(index, cur);
      }
      
      if (remove != null) {
        remove.prev.next = remove.next;
        remove.next.prev = remove.prev;
        remove.move = null;
      }
    }
    
    rowmap.clear();
    colmap.clear();
    
    long total = 0;
    Node cur = head;
    while (cur != null) {
      if (cur.move != null) {
        Move move = cur.move;
        total += ((long) move.color) * ((long) n);
        if (move.row) {
          for (Node node : colmap.values()) {
            total -= node.move.color;
          }
          rowmap.put(move.index, cur);
        } else {
          for (Node node : rowmap.values()) {
            total -= node.move.color;
          }
          colmap.put(move.index, cur);
        }
      }
      cur = cur.next;
    }    
    System.out.println(total);
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
    new ColorGrid().run();
  }
}
