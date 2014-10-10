package contests.completed.codeforces;

import java.util.Scanner;

public class A187 {
  public A187() {
    Scanner in = new Scanner(System.in);
    int n = Integer.parseInt(in.nextLine());

    if (n >= 0)
      System.out.println(n);
    else {
      int last = Math.min(Math.abs(n % 10), Math.abs(n / 10 % 10));
      System.out.println(n / 100 * 10 - last);
    }
  }

  public static void main(String[] args) {
    new A187();
  }
}
