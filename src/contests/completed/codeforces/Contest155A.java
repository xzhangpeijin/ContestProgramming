package contests.completed.codeforces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class Contest155A {
  public Contest155A() throws Exception {
    BufferedReader in = new BufferedReader(new FileReader("input.txt"));
    FileWriter f = new FileWriter("output.txt");
    //long time = System.currentTimeMillis();
    int pairs = Integer.parseInt(in.readLine());

    int[] data = new int[pairs * 2];

    StringTokenizer st = new StringTokenizer(in.readLine());
    String output = "";

    for (int x = 0; x < data.length; x++)
      data[x] = Integer.parseInt(st.nextToken());

    for (int x = 0; x < data.length; x++) {
      if (data[x] != -1) {
        boolean pair = false;
        for (int y = x + 1; y < data.length; y++) {
          if (data[y] == data[x]) {
            pair = true;
            data[y] = -1;
            output += (x + 1) + " " + (y + 1) + "\n";
            break;
          }
        }
        if (!pair) {
          output = "-1";
          break;
        }
      }
    }

    // System.out.println(output);
    // System.out.println(System.currentTimeMillis() - time);
    f.write(output);
    f.flush();
    f.close();
    in.close();
  }

  public static void main(String[] args) throws Exception {
    new Contest155A();
  }
}
