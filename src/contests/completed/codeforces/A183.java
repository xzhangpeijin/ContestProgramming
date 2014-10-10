package contests.completed.codeforces;

import java.util.Scanner;

public class A183 {
  public A183() {
    Scanner in = new Scanner(System.in);

    double two = Math.pow(2, 0.5);
    // StringTokenizer st = new StringTokenizer(in.nextLine());
    int count = 0;
    int n = Integer.parseInt(in.nextLine());

    for (int x = 5; x <= n; x++) {
      for (int y = x - 1; y >= x / two; y--) {
        if (Math.pow(x * x - y * y, 0.5) % 1 == 0) {
          count++;
          // System.out.println(x + " " + y);
        }
      }
    }

    System.out.println(count);
  }

  public static void main(String[] args) {
    new A183();
  }
}
