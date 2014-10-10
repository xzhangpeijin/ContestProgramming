package contests.completed.codeforces;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C176 {
  public static void main(String[] args) {
    new C176();
  }

  public C176() {
    Scanner in = new Scanner(System.in);

    StringTokenizer st = new StringTokenizer(in.nextLine());

    int length = Integer.parseInt(st.nextToken());
    int numon = Integer.parseInt(st.nextToken());
    int[] on = new int[length];

    st = new StringTokenizer(in.nextLine());

    for (int x = 0; x < numon; x++)
      on[Integer.parseInt(st.nextToken()) - 1] = 1;

    LinkedList<State> queue = new LinkedList<State>();
    queue.add(new State(on, numon));
    State temp;
    while ((temp = queue.poll()).num != length) {
      boolean back = true;
      for (int x = 0; x < length; x++) {
        if (temp.on[x] == 1 && back && x != 0 && temp.on[x - 1] == 0) {
          queue.add(new State(temp.on, temp.num, x - 1));
        }
        back = true;
        if (temp.on[x] == 1 && x != length - 1 && temp.on[x + 1] == 0) {
          queue.add(new State(temp.on, temp.num, x + 1));
          x++;
          back = false;
        }
      }
      // System.out.println(queue.size());
    }

    System.out.println((queue.size() + 1) % 1000000007);
  }

  public class State {
    public int[] on;
    public int num;

    public State(int[] on, int num, int index) {
      this.on = on.clone();
      this.on[index] = 1;
      this.num = num + 1;
    }

    public State(int[] on, int num) {
      this.on = on.clone();
      this.num = num;
    }
  }
}
