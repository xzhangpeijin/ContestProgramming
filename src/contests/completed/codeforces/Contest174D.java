package contests.completed.codeforces;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Contest174D {
  public static void main(String[] args) {
    new Contest174D();
  }

  public Contest174D() {
    Scanner in = new Scanner(System.in);

    int length = Integer.parseInt(in.nextLine());
    int[] data = new int[length];

    StringTokenizer st = new StringTokenizer(in.nextLine());
    for (int x = 1; x < length; x++)
      data[x] = Integer.parseInt(st.nextToken());

    int[] results = new int[length - 1];

    int[] sum = new int[length];
    sum[0] = -1;
    ArrayList<Integer> visited = new ArrayList<Integer>();
    visited.add(new Integer(0));

    for (int x = 1; x < length; x++) {
      if (data[x] == x)
        results[x - 1] = -1;
      else if (data[x] > x)
        results[x - 1] = x + data[x];
      else {
        int curx = 1 + x - data[x];
        int cury = x + data[x];
        ArrayList<Integer> visit = new ArrayList<Integer>();
        while (true) {
          if (visited.contains(curx)) {
            for (int n = 0; n < visit.size(); n++) {
              if (sum[curx - 1] == -1)
                sum[visit.get(n) - 1] = -1;
              else
                sum[visit.get(n) - 1] += sum[curx - 1];
            }
            visited.addAll(visit);
            if (sum[curx - 1] != -1)
              results[x - 1] = cury + sum[curx - 1];
            else
              results[x - 1] = -1;
            break;
          }

          visit.add(curx);
          cury += data[curx - 1];
          for (int n = 0; n < visit.size(); n++)
            sum[visit.get(n) - 1] += data[curx - 1];
          curx += data[curx - 1];

          if (curx > length) {
            results[x - 1] = cury;
            visited.addAll(visit);
            break;
          }

          cury += data[curx - 1];
          for (int n = 0; n < visit.size(); n++)
            sum[visit.get(n) - 1] += data[curx - 1];
          curx -= data[curx - 1];

          if (curx <= 0) {
            results[x - 1] = cury;
            visited.addAll(visit);
            break;
          }

          if (visit.contains(curx)) {
            results[x - 1] = -1;
            for (int n = 0; n < visit.size(); n++)
              sum[visit.get(n) - 1] = -1;
            visited.addAll(visit);
            break;
          }
        }
      }
    }

    for (int x = 0; x < results.length; x++)
      System.out.println(results[x]);
  }

}
