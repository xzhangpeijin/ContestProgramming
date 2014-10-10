package contests.completed.icpc;

import java.io.*;
import java.util.*;

public class StrangeBillboard
{	
  public int safeMod(int i) {
    i %= 2;
    if (i < 0) {
      i += 2;
    }
    return i;
  }

  public int[][] makeMatrix(int R, int C) {
    int K = R * C;
    int M[][] = new int[K][K];

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int k = C * i + j;
        M[k][k] = 1;
        if (i > 0) {
          M[k][k-C] = 1;
        }
        if (i < R-1) {
          M[k][k+C] = 1;
        }
        if (j > 0) {
          M[k][k-1] = 1;
        }
        if (j < C-1) {
          M[k][k+1] = 1;
        }
      }
    }
    return M;
  }

  public void swap(int v[], int i, int j) {
    int temp = v[i]; 
    v[i] = v[j]; 
    v[j] = temp;
  }

  public void swapCols(int M[][], int i, int j) {
    for (int k = 0; k < M.length; k++) {
      int temp = M[k][i]; 
      M[k][i] = M[k][j]; 
      M[k][j] = temp;
    }
  }

  public void swapRows(int M[][], int i, int j) {
    for (int k = 0; k < M[0].length; k++) {
      int temp = M[i][k]; 
      M[i][k] = M[j][k]; 
      M[j][k] = temp;
    }
  }

  public int gauss(int M[][], int perm[], int y[]) {
    int K = M.length;
    
    for (int p = 0; p < K; p++) {
      perm[p] = p;
    }

    for (int p = 0; p < K; p++) {
      int c = p, r = p;
      while (c < K && M[r][c] == 0) {
        r++;
        if (r >= K) { c++; r = p; }
      }
      if (c >= K) {
        return p;
      }

      swapRows(M, r, p); 
      swap(y, r, p);
      swapCols(M, c, p); 
      swap(perm, c, p);

      int u = M[p][p]; M[p][p] = 1;
      for (int q = p+1; q < K; q++) M[p][q] = safeMod(M[p][q] * u);
      y[p] = safeMod(y[p] * u);

      for (r = p+1; r < K; r++) {
        int v = M[r][p]; 
        if (v == 0) continue;
        M[r][p] = 0;
        for (int q = p+1; q < K; q++) 
          M[r][q] = safeMod(M[r][q] - v * M[p][q]);
        y[r] = safeMod(y[r] - v * y[p]);
      }
    }

    return K;
  }

  public void backSubst(int K, int M[][], int x[], int perm[], int y[], int rank) {
    for (int p = rank-1; p >= 0; p--) {
      int u = y[p];
      for (int q = p+1; q < K; q++) {
        u = safeMod(u - M[p][q] * x[perm[q]]);
      }
      x[perm[p]] = u;
    }
  }

  public int count(int v[]) {
    int total = 0;
    for (int i : v) {
      total += i;
    }
    return total;
  }

  public int solve(int R, int C, int y[]) {
    int M[][] = makeMatrix(R, C);
    int K = R * C;
    int perm[] = new int[K];
    int rank = gauss(M, perm, y);

    for (int i = rank; i < K; i++) {
      if (y[i] != 0) {
        return -1;
      }
    }

    int n = 1;
    for (int i = rank; i < K; i++) {
      n *= 3;
    }
    
    int min = Integer.MAX_VALUE;

    for (int s = 0; s < n; s++) {
      int x[] = new int[K];
      int k = s;
      for (int i = K-1; i >= rank; i--) {
        x[perm[i]] = k % 3;
        k /= 3;
      }
      backSubst(K, M, x, perm, y, rank);
      min = Math.min(min, count(x));
    }
    
    return min;
  }

  public void solve() throws IOException 
  {
    int r, c;
    while ((r = nextInt()) != 0 && (c = nextInt()) != 0) {
      int[] input = new int[r * c];
      int index = 0;
      for (int x = 0; x < r; x++) {
        String line = nextLine();
        for (int y = 0; y < line.length(); y++) {
          input[index] = (line.charAt(y) == 'X') ? 1 : 0;
          index++;
        }
      }
      
      int sol = solve(r, c, input);
      if (sol == -1) {
        System.out.println("Damaged billboard.");
      } else {
        System.out.format("You have to tap %d tiles.\n", sol);
      }
    }
  }

  public BufferedReader br;
  public StringTokenizer st;
  public PrintWriter out;

  public String nextToken() throws IOException {
    while(st == null || !st.hasMoreTokens()) {
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

  public long nextLong() throws  IOException {
    return Long.parseLong(nextToken());
  }

  public double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  public void run() throws IOException 
  {	
    boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    oj = true;
    br = new BufferedReader( new InputStreamReader( oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter( oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException 
  {
    new StrangeBillboard().run();
  }
}
