package contests.completed.codeforces;

import java.util.Scanner;

public class B187 {
  public B187() {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();

    int[] sums = new int[input.length()];

    for (int x = 1; x < input.length(); x++)
      sums[x] = sums[x - 1] + ((input.charAt(x) == input.charAt(x - 1)) ? 1 : 0);

    int queries = in.nextInt();

    for (int x = 0; x < queries; x++) {
      System.out.println(-1 * sums[in.nextInt() - 1] + sums[in.nextInt() - 1]);
    }
  }

  public static void main(String[] args) {
    new B187();
  }
}
