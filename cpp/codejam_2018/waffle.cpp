#include <bits/stdc++.h>
using namespace std;

int main() {
  int T;
  cin >> T;

  int xsum[100][100];
  int rowsum[100];
  int colsum[100];
  int rsplits[100];
  int csplits[100];

  for (int t = 1; t <= T; t++) {
    int R, C, H, V;
    cin >> R >> C >> H >> V;

    memset(xsum, 0, sizeof(xsum));
    memset(rowsum, 0, sizeof(rowsum));
    memset(colsum, 0, sizeof(colsum));
    
    char ch;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        cin >> ch;
        bool cookie = (ch == '@');
        if (cookie) {
          rowsum[i]++;
          colsum[j]++;
        }
        xsum[i][j] = rowsum[i];
        if (i > 0) {
          xsum[i][j] += xsum[i - 1][j];
        }
      }
    }
    int count = xsum[R - 1][C - 1];

    int divisors = (H + 1) * (V + 1);
    cout << "Case #" << t << ": ";
    if (count % divisors != 0) {
      cout << "IMPOSSIBLE" << endl;
      continue;
    }

    int split = count / divisors;

    int rowchunk = split * (V + 1);
    int colchunk = split * (H + 1);

    bool possible = true;

    int rowind = 0;
    int rowtar = rowchunk;
    int rowcum = 0;
    for (int i = 0; i < R; i++) {
      rowcum += rowsum[i];
      if (rowcum == rowtar) {
        rsplits[rowind++] = i;
        rowtar += rowchunk;
      } else if (rowcum > rowtar) {
        possible = false;
        break;
      }
    }
    
    int colind = 0;
    int coltar = colchunk;
    int colcum = 0;
    for (int i = 0; i < C; i++) {
      colcum += colsum[i];
      if (colcum == coltar) {
        csplits[colind++] = i;
        coltar += colchunk;
      } else if (colcum > coltar) {
        possible = false;
        break;
      }
    }

    for (int i = 0; i < H + 1; i++) {
      if (!possible) break;
      for (int j = 0; j < V + 1; j++) {
        int cellsum = xsum[rsplits[i]][csplits[j]];
        if (i > 0) {
          cellsum -= xsum[rsplits[i-1]][csplits[j]];
        }
        if (j > 0) {
          cellsum -= xsum[rsplits[i]][csplits[j-1]];
        }
        if (i > 0 && j > 0) {
          cellsum += xsum[rsplits[i-1]][csplits[j-1]];
        }
        if (cellsum != split) {
          possible = false;
          break;
        }
      }
    }


    if (possible) {
      cout << "POSSIBLE" << endl;
    } else {
      cout << "IMPOSSIBLE" << endl;
    }
  }
}
