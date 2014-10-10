package contests.completed.codeforces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Contest136B {
  public Contest136B() {
    Scanner in = new Scanner(System.in);

    Integer num = Integer.valueOf(in.nextLine());

    HashSet<Integer> digits = new HashSet<Integer>();
    int temp = num;
    while (temp > 0) {
      digits.add(temp % 10);
      temp /= 10;
    }

    ArrayList<Integer> factors = new ArrayList<Integer>();

    for (int x = 1; x <= Math.pow(num, 0.5); x++) {
      if (num % x == 0) {
        factors.add(x);
        if (x != Math.pow(num, 0.5))
          factors.add(num / x);
      }
    }

    int total = 0;

    for (int x = 0; x < factors.size(); x++) {
      int a = factors.get(x);

      while (a > 0) {
        HashSet<Integer> tempset = cloneHash(digits);
        int size = tempset.size();
        tempset.add(a % 10);
        if (tempset.size() == size) {
          total++;
          a = 0;
        }
        a /= 10;
      }

    }

    System.out.println(total);
  }

  public HashSet<Integer> cloneHash(HashSet<Integer> a) {
    HashSet<Integer> result = new HashSet<Integer>();
    Iterator<Integer> it = a.iterator();
    while (it.hasNext())
      result.add((Integer) it.next());
    return result;
  }

  public static void main(String[] args) {
    new Contest136B();
  }
}
