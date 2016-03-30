package contests.completed.icpc;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class FacePalm {
  
  public void solve() throws IOException {
    int n = nextInt();
    int k = nextInt();
    int[] arr = new int[n];
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = nextInt();
      min = Math.min(min,  arr[i]);
    }
    
    int[] sums = new int[n - k + 1];
    int sum = 0;
    Stack<Integer> insert = new Stack<Integer>();
    for (int i = 0; i < k; i++) {
      sum += arr[i]; 
      insert.push(i);
    }
    
    int change = 0;
    for (int i = 0; i <= n - k; i++) {
      if (i == 0) {
        sums[i] = sum;
      } else {
        sums[i] = sums[i - 1] + arr[i + k - 1] - arr[i - 1];
        insert.push(i + k - 1);
      }
      
      while(sums[i] >= 0) {
        int ins = insert.peek();
        int diff = arr[ins] - min;
        if (diff <= sums[i]) {
          arr[ins] = min;
          change += diff;
          sums[0] -= diff;
          insert.pop();;
        } else {
          arr[ins] -= sums[i] + 1;
          change += sums[i] + 1;
          sums[i] = -1;
        }
      }
    }
    
    System.out.println(change);
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i != 0) {
        buf.append(" ");
      }
      buf.append(arr[i]);
    }
    System.out.println(buf.toString());
  }

  public BufferedReader br;
  public StringTokenizer st;
  public PrintWriter out;

  public String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
      st = new StringTokenizer(br.readLine());
    }

    return st.nextToken();
  }

  public String nextLine() throws IOException {
    return br.readLine();
  }

  public int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  public long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  public double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  public void run() throws IOException {
    boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    oj = true;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new FacePalm().run();
  }
}
