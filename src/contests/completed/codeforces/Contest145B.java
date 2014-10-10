package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Contest145B {
  public Contest145B() throws Exception {
    BufferedReader in = new BufferedReader(new FileReader("input.txt"));
    FileWriter f = new FileWriter("output.txt");

    String[] temp = in.readLine().split(" ");

    int hours = Integer.valueOf(temp[0]);
    int read = Integer.valueOf(temp[1]);

    Hour[] schedule = new Hour[hours];

    temp = in.readLine().split(" ");

    for (int x = 0; x < hours; x++) {
      schedule[x] = new Hour(x + 1, Integer.valueOf(temp[x]));
    }

    Arrays.sort(schedule);

    f.write(schedule[read - 1].getValue() + "\n");

    for (int x = 0; x < read; x++) {
      f.write(schedule[x].getIndex() + " ");
    }

    f.flush();
    f.close();
    in.close();
  }

  public class Hour implements Comparable<Hour> {
    private int index;
    private int value;

    public Hour(int index, int value) {
      this.index = index;
      this.value = value;
    }

    public int getIndex() {
      return index;
    }

    public int getValue() {
      return value;
    }

    public int compareTo(Hour a) {
      return a.getValue() - value;
    }
  }

  public static void main(String[] args) throws Exception {
    new Contest145B();
  }
}
