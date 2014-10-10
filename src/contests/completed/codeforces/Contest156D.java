package contests.completed.codeforces;

import java.util.Scanner;

public class Contest156D {
  public static void main(String[] args) {
    new Contest156D();
  }

  public Contest156D() {
    Scanner in = new Scanner(System.in);

    int size = in.nextInt();
    int xpos = in.nextInt();
    int ypos = in.nextInt();
    int des = in.nextInt();

    int time = 1;
    int total = 1;
    while (total < des) {
      time++;
      total = sq(time);

      int[] d = new int[4];
      d[0] = (xpos + time > size) ? xpos + time - size : 0;
      d[1] = (xpos - time < 0) ? xpos - time + size : 0;
      d[2] = (ypos + time > size) ? ypos + time - size : 0;
      d[3] = (ypos + time < 0) ? ypos + time - size : 0;

      for (int x = 0; x < 4; x++)
        total -= x * x;

      if (d[0] > 0 && d[2] > 0) {
        int val = time - 2;
        int d1 = time - 1 - d[0];
        int d2 = time - 1 - d[2];
        val -= d1 + d2;
        total += tri(val);
      }
      if (d[0] > 0 && d[3] > 0) {
        int val = time - 2;
        int d1 = time - 1 - d[0];
        int d2 = time - 1 - d[3];
        val -= d1 + d2;
        total += tri(val);
      }
      if (d[1] > 0 && d[2] > 0) {
        int val = time - 2;
        int d1 = time - 1 - d[1];
        int d2 = time - 1 - d[2];
        val -= d1 + d2;
        total += tri(val);
      }
      if (d[1] > 0 && d[3] > 0) {
        int val = time - 2;
        int d1 = time - 1 - d[1];
        int d2 = time - 1 - d[3];
        val -= d1 + d2;
        total += tri(val);
      }
      System.out.println(total);
    }
    System.out.println(time - 1);
  }

  public int tri(int n) {
    return n * (n + 1) / 2;
  }

  public int sq(int n) {
    return n * (n + 1) * (2 * n + 1) / 6;
  }
}
