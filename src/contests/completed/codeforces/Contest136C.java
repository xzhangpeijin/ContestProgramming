package contests.completed.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Contest136C {
  public Contest136C() {
    Scanner in = new Scanner(System.in);

    Integer length = Integer.valueOf(in.nextLine());

    int[] digits1 = new int[length];
    int[] digits2 = new int[length];

    for (int x = 0; x < length; x++) {
      digits1[x] = in.nextInt();
      digits2[x] = digits1[x];
    }

    Arrays.sort(digits2);

    int incorrect = 0;
    for (int x = 0; x < length; x++)
      if (digits1[x] != digits2[x])
        incorrect++;

    if (incorrect <= 2)
      System.out.println("YES");
    else
      System.out.println("NO");

  }

  public static void main(String[] args) {
    new Contest136C();
  }
}
