package contests.completed.codeforces;

import java.util.Scanner;

public class Contest156C {
  public static void main(String[] args) {
    new Contest156C();
  }

  public Contest156C() {
    Scanner in = new Scanner(System.in);

    int[] data = new int[in.nextInt()];

    for (int x = 0; x < data.length; x++)
      data[x] = in.nextInt();

    int maxlen = 0;
    for (int x = 0; x < data.length / 2; x++) {
      for (int y = x + 1; y < data.length / 2 + 1; y++) {
        int diff = y - x;
        if (data.length / diff > maxlen) {
          int index = y + diff;
          int len = 2;
          boolean first = true;
          while (index < data.length && ((first) ? data[x] : data[y]) == data[index]) {
            len++;
            index += diff;
            first = !first;
          }
          maxlen = Math.max(maxlen, len);
        }
      }
    }
    System.out.println(maxlen);
  }
}
