package contests.completed.misc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Anagram {
  
  public void solve() throws IOException {
    String nextline = "";
    while ((nextline = nextLine()) != null && nextline.length() > 0) {
      nextline = nextline.toLowerCase();
      int[] counts = new int[26];
      for (char a : nextline.toCharArray()) {
        counts[a - 'a']++;
      }
      List<Character> even = new ArrayList<Character>();
      
      int toremove = 0;
      for (int i = 0; i < 26; i++) {
        if (counts[i] == 0) {
          continue;
        }
        if (counts[i] > 1) {
          even.add((char)('a' + i));
        }
        if (counts[i] % 2 == 1) {
          toremove++;
        }
      }
      if (toremove >= 1) {
        toremove--;
      }
      
      int length = 0;
      List<Integer> divide = new ArrayList<Integer>();
      for (char a : even) {
        int val = counts[a - 'a'] / 2;
        divide.add(val);
        length += val;
      }
      //System.out.println(length);
      long total = 1;
      for (int i = 2; i <= length; i++) {
        total *= i;
      }
      for (int div : divide) {
        //System.out.println(div);
        for (int i = 2; i <= div; i++) {
          total /= i;
        }
      }
//      if (length % 2 == 0) {
//        total /= 2;
//      }
      System.out.println(toremove + "," + total);
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
    new Anagram().run();
  }
}
