package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ACMNoWin {
  public void solve() throws IOException {
    while (true) {
      String input = nextToken();
      if (input.equals("JOKER"))
        break;

      int player = 0;
      boolean pace = false;
      int dealer = 0;
      boolean dace = false;

      int card1 = val(input.charAt(0));
      int card2 = val(input.charAt(1));
      int card3 = val(input.charAt(2));
      int card4 = val(input.charAt(3));

      if (card1 == 11 || card3 == 11)
        pace = true;
      if (card2 == 11 || card4 == 11)
        dace = true;

      player += card1 + card3;
      dealer += card2 + card4;

      if (card1 == 11 && card3 == 11)
        player = 12;
      if (card2 == 11 && card4 == 11)
        dealer = 12;

      input = input.substring(4, input.length());
      boolean won = false;
      while (player < 21 && !won && input.length() > 0) {
        int newdealer = dealer;
        int index = 0;
        while (newdealer < 17 && index < input.length()) {
          int card = val(input.charAt(index));
          newdealer += card;
          if (card == 11) {
            if (newdealer > 21)
              newdealer -= 10;
            else
              dace = true;
          }

          if (newdealer > 21 && dace) {
            newdealer -= 10;
            dace = false;
          }
          index++;
        }
        if (newdealer > 21 || player >= newdealer)
          won = true;

        int card = val(input.charAt(0));
        player += card;
        if (card == 11) {
          if (player > 21)
            player -= 10;
          else
            pace = true;
        }
        if (player > 21 && pace) {
          player -= 10;
          pace = false;
        }
        input = input.substring(1, input.length());
      }
      if (dealer > 21 || (player <= 21 && player >= dealer))
        won = true;
      if (won)
        System.out.println("Yes");
      else
        System.out.println("No");
    }
  }

  public int val(char a) {
    switch (a) {
    case 'K':
      return 10;
    case 'Q':
      return 10;
    case 'J':
      return 10;
    case 'T':
      return 10;
    case 'A':
      return 11;
    default:
      return a - 48;
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
    new ACMNoWin().run();
  }
}
