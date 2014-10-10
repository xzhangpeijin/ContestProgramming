package contests.completed.codeforces;

import java.util.Scanner;
import java.util.StringTokenizer;

public class D188 {
  public D188() {
    int[][] arr = new int[131][131];

    Scanner in = new Scanner(System.in);
    StringTokenizer st = new StringTokenizer(in.nextLine());

    int n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());

    arr[65][65] = n;

    boolean done = false;
    while (!done) {
      done = true;
      for (int x = 0; x < 131; x++) {
        for (int y = 0; y < 131; y++) {
          if (arr[x][y] >= 4) {
            done = false;
            arr[x - 1][y] += arr[x][y] / 4;
            arr[x + 1][y] += arr[x][y] / 4;
            arr[x][y + 1] += arr[x][y] / 4;
            arr[x][y - 1] += arr[x][y] / 4;
            arr[x][y] %= 4;
          }
        }
      }
    }

    for (int x = 0; x < t; x++) {
      st = new StringTokenizer(in.nextLine());
      int xco = Integer.parseInt(st.nextToken());
      int yco = Integer.parseInt(st.nextToken());

      if (xco + 65 < 0 || xco + 65 > 130 || yco + 65 < 0 || yco + 65 > 130)
        System.out.println(0);
      else
        System.out.println(arr[xco + 65][yco + 65]);
    }
  }

  public static void main(String[] args) {
    new D188();
  }
}
