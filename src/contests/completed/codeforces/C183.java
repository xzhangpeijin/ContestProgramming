package contests.completed.codeforces;

import java.util.Scanner;

public class C183 {
  public C183() {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());

    if (n % 2 == 1) {
      if (n == 1) {
        System.out.println(0);
        System.out.println(0);
        System.out.println(0);
      } else {
        for (int x = 0; x < n; x++)
          System.out.print(x + " ");
        System.out.println();
        for (int x = 1; x < n; x++)
          System.out.print(x + " ");
        System.out.println(0);
        int count = 1;
        for (int x = 0; x < n; x++) {
          System.out.print(count + " ");
          count = (count + 2) % n;
        }
      }
    } else
      System.out.println(-1);
  }

  public static void main(String[] args) {
    new C183();
  }
}
