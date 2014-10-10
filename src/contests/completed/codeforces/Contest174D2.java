package contests.completed.codeforces;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Contest174D2 {
  public static void main(String[] args) {
    new Contest174D2();
  }

  public Contest174D2() {
    Scanner in = new Scanner(System.in);

    int length = Integer.parseInt(in.nextLine());
    int[] data = new int[length];
    StringTokenizer st = new StringTokenizer(in.nextLine());
    for (int x = 1; x < length; x++)
      data[x] = Integer.parseInt(st.nextToken());
    int[] results = new int[length - 1];
    for (int x = 1; x < length; x++) {
      data[0] = x;
      ArrayList<Integer> visited = new ArrayList<Integer>();

      int xval = 1, yval = 0;
      while (xval > 0 && xval <= length && !visited.contains(xval)) {
        visited.add(xval);
        yval += data[xval - 1];
        xval += data[xval - 1];
        if (xval <= 0 || xval > length)
          break;
        yval += data[xval - 1];
        xval -= data[xval - 1];
      }
      if (visited.contains(xval))
        results[x - 1] = -1;
      else
        results[x - 1] = yval;
    }
    for (int x = 0; x < results.length; x++)
      System.out.println(results[x]);
  }

}
