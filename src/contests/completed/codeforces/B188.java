package contests.completed.codeforces;

import java.util.Scanner;

public class B188 {
  public B188() {
    Scanner in = new Scanner(System.in);
    String input = in.nextLine();

    int[] arr = new int[input.length()];

    int index = input.indexOf("heavy");

    while (index >= 0) {
      arr[index] = 1;
      index = input.indexOf("heavy", index + 1);
    }

    index = input.indexOf("metal");

    while (index >= 0) {
      arr[index] = 2;
      index = input.indexOf("metal", index + 1);
    }

    long count = 0;
    long mult = 0;

    for (int x = 0; x < arr.length; x++) {
      if (arr[x] == 1)
        mult++;
      if (arr[x] == 2)
        count += mult;
    }

    System.out.println(count);
  }

  public static void main(String[] args) {
    new B188();
  }
}
