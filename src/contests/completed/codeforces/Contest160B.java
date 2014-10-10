package contests.completed.codeforces;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Contest160B {
  public static void main(String[] args) {
    new Contest160B();
  }

  public Contest160B() {
    Scanner in = new Scanner(System.in);

    StringTokenizer st = new StringTokenizer(in.nextLine());

    int count = Integer.parseInt(st.nextToken());
    int change = Integer.parseInt(st.nextToken());

    int[] num = new int[count];
    st = new StringTokenizer(in.nextLine());

    for (int x = 0; x < count; x++)
      num[x] = Integer.parseInt(st.nextToken());

    boolean haszero = false;
    int index = 0;
    int total = 0;
    while (index < count && change > 0 && num[index] < 0) {
      total += Math.abs(num[index]);
      index++;
      change--;
    }

    for (int x = index; x < count; x++)
      total += num[x];

    if (index < count && num[index] == 0)
      haszero = true;

    if (change > 0 && change % 2 == 1 && !haszero)
      total -= 2 * Math.abs(num[Math.max(0, index - 1)]);

    System.out.println(total);
  }

}
