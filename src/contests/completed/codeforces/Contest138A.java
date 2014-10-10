package contests.completed.codeforces;

import java.math.BigInteger;
import java.util.Scanner;

public class Contest138A {
  public Contest138A() {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();

    BigInteger total = BigInteger.valueOf(a);
    total = total.multiply(BigInteger.valueOf(b));
    total = total.multiply(BigInteger.valueOf(c));

    total = BigInteger.valueOf((long) Math.sqrt(total.doubleValue()));

    int sum = 0;

    sum += total.divide(BigInteger.valueOf(a)).intValue();
    sum += total.divide(BigInteger.valueOf(b)).intValue();
    sum += total.divide(BigInteger.valueOf(c)).intValue();

    System.out.println(sum * 4);
  }

  public static void main(String[] args) {
    new Contest138A();
  }
}
