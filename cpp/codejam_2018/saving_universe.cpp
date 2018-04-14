#include <bits/stdc++.h>
using namespace std;

int main() {
  int T, D;
  string P;

  cin >> T;
  for (int i = 0; i < T; i++) {
    cin >> D >> P;

    int bins[30] = {0};
    int j = 0;
    int count = 0, sum = 0, boost = 1;
    for (unsigned k = 0; k < P.size(); k++) {
      if (P[k] == 'S') {
        bins[j]++;
        count++;
        sum += boost;
      } else {
        boost = boost << 1;
        j++;
      }
    }
    cout << "Case #" << (i + 1) << ": ";
    if (count > D) {
      cout << "IMPOSSIBLE" << endl;
      continue;
    } else if (sum <= D) {
      cout << 0 << endl;
      continue;
    }
    int swaps = 0;
    boost = boost >> 1;
    while (bins[j] == 0) {
      j--;
      boost = boost >> 1;
    }
    while (sum > D) {
      if (sum - (bins[j] - 1) * boost > D) {
        swaps += bins[j];
        sum -= bins[j] * boost;
        bins[j-1] += bins[j];
        j--;
        boost = boost >> 1;
      } else {
        swaps += (sum - D) / boost + ((sum - D) % boost != 0);
        break;
      }
    }
    cout << swaps << endl;
  }
  return 0;
}
