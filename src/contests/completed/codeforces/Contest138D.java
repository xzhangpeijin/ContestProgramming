package contests.completed.codeforces;

import java.util.Scanner;

public class Contest138D {
  public Contest138D() {
    Scanner in = new Scanner(System.in);

    String a = in.nextLine();
    String b = in.nextLine();

    boolean possible = true;

    for (int x = 0; x < b.length(); x++) {
      int index = a.indexOf(b.charAt(x));
      if (index == -1) {
        possible = false;
        x = b.length();
      } else {
        a = a.substring(index + 1, a.length());
      }
    }
    System.out.println(possible);
    if (possible) {
      for (int x = 0; x < a.length(); x++)
        if (b.indexOf(a.charAt(x)) == -1)
          possible = false;
    }
    if (possible)
      System.out.println("Yes");
    if (!possible)
      System.out.println("No");
  }

  public static void main(String[] args) {
    new Contest138D();
  }
}
