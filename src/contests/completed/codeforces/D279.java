package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class D279 {
  
  static class State {
    public long a;
    public long b;
    public int moves;
    private long squares;
    
    public State(long a, long b, int moves) {
      this.a = a;
      this.b = b;
      this.squares = a * b;
      this.moves = moves;
    }
    
    public String toString() {
      return a + " " + b;
    }
    
    public long getSquares() {
      return squares;
    }
  }
  
  public void solve() throws IOException {
     State first = new State(nextLong(), nextLong(), 0);
     State second = new State(nextLong(), nextLong(), 0);
     
     Map<Long, State> firstmap = new HashMap<Long, State>();
     firstmap.put(first.getSquares(), first);
     
     Map<Long, State> secondmap = new HashMap<Long, State>();
     secondmap.put(second.getSquares(), second);
     
     Queue<State> search = new LinkedList<State>();
     
     search.add(first);
     while (search.size() > 0) {
       State cur = search.poll();
       if (firstmap.get(cur.getSquares()).equals(cur)) {
         if (cur.a % 2 == 0) {
           State candidate = new State(cur.a / 2, cur.b, cur.moves + 1);
           if (firstmap.get(candidate.getSquares()) == null || 
               firstmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             firstmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
         if (cur.a % 3 == 0) {
           State candidate = new State(2 * cur.a / 3, cur.b, cur.moves + 1);
           if (firstmap.get(candidate.getSquares()) == null || 
               firstmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             firstmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
         if (cur.b % 2 == 0) {
           State candidate = new State(cur.a, cur.b / 2, cur.moves + 1);
           if (firstmap.get(candidate.getSquares()) == null || 
               firstmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             firstmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
         if (cur.b % 3 == 0) {
           State candidate = new State(cur.a, 2 * cur.b / 3, cur.moves + 1);
           if (firstmap.get(candidate.getSquares()) == null || 
               firstmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             firstmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
       }
     }
     
     search.add(second); 
     while (search.size() > 0) {
       State cur = search.poll();
       if (secondmap.get(cur.getSquares()).equals(cur)) {
         if (cur.a % 2 == 0) {
           State candidate = new State(cur.a / 2, cur.b, cur.moves + 1);
           if (secondmap.get(candidate.getSquares()) == null || 
               secondmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             secondmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
         if (cur.a % 3 == 0) {
           State candidate = new State(2 * cur.a / 3, cur.b, cur.moves + 1);
           if (secondmap.get(candidate.getSquares()) == null || 
               secondmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             secondmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
         if (cur.b % 2 == 0) {
           State candidate = new State(cur.a, cur.b / 2, cur.moves + 1);
           if (secondmap.get(candidate.getSquares()) == null || 
               secondmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             secondmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
         if (cur.b % 3 == 0) {
           State candidate = new State(cur.a, 2 * cur.b / 3, cur.moves + 1);
           if (secondmap.get(candidate.getSquares()) == null || 
               secondmap.get(candidate.getSquares()).moves > cur.moves + 1) {
             secondmap.put(candidate.getSquares(), candidate);
             search.add(candidate);
           }
         }
       }
     }
     
     int minmoves = Integer.MAX_VALUE;
     for (long squares : firstmap.keySet()) {
       if (secondmap.containsKey(squares)) {
         minmoves = Math.min(minmoves, firstmap.get(squares).moves + secondmap.get(squares).moves);
       }
     }
     
     for (long squares : firstmap.keySet()) {
       if (secondmap.containsKey(squares) && 
           firstmap.get(squares).moves + secondmap.get(squares).moves == minmoves) {
         System.out.println(minmoves);
         System.out.println(firstmap.get(squares).toString());
         System.out.println(secondmap.get(squares).toString());
         return;
       }
     }
     System.out.println(-1);
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
    new D279().run();
  }
}
