

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class WordSearch {
  static enum Dir {
    N, S, E, W, NE, NW, SW, SE;
  }
  
  static Dir search(char[][] board, int x, int y, String word) {
    for (Dir dir : Dir.values()) {
      if (searchImpl(board, x, y, 0, word, dir)) {
        return dir;
      }
    }
    return null;
  }
  
  static boolean searchImpl(char[][] board, int x, int y, int l, String word, Dir dir) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
      return false;
    }
    if (board[x][y] != word.charAt(l)) {
      return false;
    }
    if (++l == word.length()) {
      return true;
    }
    int nextx = x;
    int nexty = y;
    switch (dir) {
    case N: nextx--; break;
    case S: nextx++; break;
    case E: nexty++; break;
    case W: nexty--; break;
    case NE: nextx--; nexty++; break;
    case NW: nextx--; nexty--; break;
    case SW: nextx++; nexty--; break;
    case SE: nextx++; nexty++; break;
    }
    return searchImpl(board, nextx, nexty, l, word, dir);
  }
  
  static class Data {
    int x, y;
    Dir dir;
    String word;
    public Data(String word, int x, int y, Dir dir) {
      this.word = word;
      this.x = x;
      this.y = y;
      this.dir = dir;
    }
    public String toString() {
      return String.format("%s(%d,%d,%s)", word, x, y, dir);
    }
  }
  
  public void solve() throws IOException {
    int n = nextInt();
    nextLine();
    char[][] data = new char[n][];
    for (int i = 0; i < n; i++) {
      data[i] = nextLine().toCharArray();
    }
    nextLine();
    List<String> words = new ArrayList<String>();
    String input = "";
    while ((input = nextLine()) != null && input.length() > 0) {
      words.add(input);
    }
    
    Map<String, Data> map = new HashMap<String, Data>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (String word : words) {
          Dir dir = search(data, i, j, word);
          if (dir != null && !map.containsKey(word)) {
            map.put(word, new Data(word, i + 1, j + 1, dir));
          }
        }
      }
    }
    
    for (String word : words) {
      System.out.println(map.get(word).toString());
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
    new WordSearch().run();
  }
}
