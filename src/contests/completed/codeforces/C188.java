package contests.completed.codeforces;

import java.util.Scanner;
import java.util.StringTokenizer;

public class C188 {
  public C188() {
    Scanner in = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(in.nextLine());

    long x = Long.parseLong(st.nextToken());
    long y = Long.parseLong(st.nextToken());
    long m = Long.parseLong(st.nextToken());

    if (x <= 0 && y <= 0 && x < m && y < m)
      System.out.println(-1);
    else if (x > m || y > m)
      System.out.println(0);
    else {
      long moves = 0;
      long min = Math.min(x, y);
      y = Math.max(x, y);
      x = min;

      if (m > 0 && x < 0 && y > 0) {
        long count = Math.abs(x / y);

        x += count * y;
        moves += count;
      } else if (m > 0 && x < 0 && y > 0) {
        long count = Math.abs((x - m) / y);

        x += count * y;
        moves += count;
      }

      while (x < m && y < m) {
        if (x < y)
          x += y;
        else
          y += x;
        moves++;
      }
      System.out.println(moves);
    }
  }

  public static void main(String[] args) {
    new C188();
  }
}
