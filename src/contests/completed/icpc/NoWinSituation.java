package contests.completed.icpc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NoWinSituation {
  public void solve() throws IOException {
    String cards;
    while (!(cards = nextLine()).equals("JOKER")) {
      int player = val(cards.charAt(0)) + val(cards.charAt(2));
      boolean hasace = false;
      if (cards.charAt(0) == 'A' || cards.charAt(2) == 'A') {
        hasace = true;
      }
      int dealerstart = val(cards.charAt(1)) + val(cards.charAt(3));
      boolean dstartaces = false;
      if (cards.charAt(1) == 'A' || cards.charAt(3) == 'A') {
        dstartaces = true;
      }
      boolean canwin = false;

      for (int x = 4; x < cards.length(); x++) {
        if (player > 21) {
          break;
        }
        int tobeat = player;
        if (player <= 11 && hasace) {
          tobeat += 10;
        }
        if (tobeat == 21) {
          canwin = true;
          break;
        }

        int dealer = dealerstart;
        boolean dealerace = dstartaces;
        int index = x;
        while (index < cards.length() && dealer < 17
            && (!dealerace || dealer + 10 < 17 || dealer + 10 > 21)) {
          dealer += val(cards.charAt(index));
          if (cards.charAt(index) == 'A') {
            dealerace = true;
          }
          index++;
        }
        if (dealer <= 11 && dealerace) {
          dealer += 10;
        }

        // System.out.println(x + " " + tobeat + " " + dealer);

        if (tobeat >= dealer || dealer > 21) {
          canwin = true;
          break;
        }

        player += val(cards.charAt(x));
        if (cards.charAt(x) == 'A') {
          hasace = true;
        }
      }
      if (player <= 21 && player >= dealerstart) {
        canwin = true;
      }
      if (canwin) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
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
      return 1;
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
    new NoWinSituation().run();
  }
}
