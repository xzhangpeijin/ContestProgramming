package contests.completed.codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class Contest136E {
  public Contest136E() {
    Scanner in = new Scanner(System.in);

    int length = in.nextInt();

    int[] a = new int[length];
    ArrayList<Integer> b = new ArrayList<Integer>();

    for (int x = 0; x < length; x++)
      a[x] = in.nextInt();

    for (int x = 0; x < length; x++)
      b.add(in.nextInt());

    for (int x = 0; x < length; x++) {
      int min = length;
      for (int y = 0; y < length; y++) {
        min = Math.min(min, Math.abs(b.indexOf(a[y]) - y));
        if (min == 0)
          y = length;
      }
      System.out.println(min);

      int temp = b.remove(0);
      b.add(temp);
    }

  }

  public static void main(String[] args) {
    new Contest136E();
  }
}
