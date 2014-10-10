package contests.completed.codeforces;

import java.util.Scanner;
import java.util.StringTokenizer;

public class B180 {
  public static void main(String[] args) {
    new B180();
  }

  public B180() {
    Scanner in = new Scanner(System.in);

    StringTokenizer st = new StringTokenizer(in.nextLine());

    int t = Integer.parseInt(st.nextToken());

    int[] start = new int[2];
    int[] end = new int[2];

    start[0] = Integer.parseInt(st.nextToken());
    start[1] = Integer.parseInt(st.nextToken());
    end[0] = Integer.parseInt(st.nextToken());
    end[1] = Integer.parseInt(st.nextToken());

    int xdist = Math.abs(start[0] - end[0]);
    int ydist = Math.abs(start[1] - end[1]);

    char xdir = (start[0] - end[0] > 0) ? 'W' : 'E';
    char ydir = (start[1] - end[1] > 0) ? 'S' : 'N';

    char[] wind = in.nextLine().toCharArray();

    int time = -1;
    for (int x = 0; x < t; x++) {
      if (wind[x] == xdir)
        xdist--;
      if (wind[x] == ydir)
        ydist--;
      if (xdist <= 0 && ydist <= 0) {
        time = x + 1;
        break;
      }
    }

    System.out.println(time);
  }

}
