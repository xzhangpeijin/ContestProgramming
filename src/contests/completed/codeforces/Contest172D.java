package contests.completed.codeforces;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Contest172D {
  public static void main(String[] args) {
    new Contest172D();
  }

  public Contest172D() {
    Scanner in = new Scanner(System.in);
    int length = Integer.parseInt(in.nextLine());
    int max = 0;
    int[] seq = new int[length];
    StringTokenizer st = new StringTokenizer(in.nextLine());
    for (int x = 0; x < length; x++) {
      seq[x] = Integer.parseInt(st.nextToken());
      max = Math.max(seq[x], max);
    }

    int temp = max;
    int pow = 0;
    while (temp > 0) {
      temp /= 2;
      pow++;
    }
    int floor = (int) Math.pow(2, pow - 1);

    for (int x = 0; x < length; x++) {
      if (seq[x] >= floor) {

      }
    }
    System.out.println(pow);

  }

}
