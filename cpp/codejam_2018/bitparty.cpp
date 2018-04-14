#include <bits/stdc++.h>
using namespace std;

struct Cashier {
  long long m, s, p;
  long long compute(long long t) {
    return max(min((t - p) / s, m), 0LL);
  }
};

int main() {
  int T;
  cin >> T;

  Cashier cashiers[1000];
  for (int t = 1; t <= T; t++) {
    long long R, B, C;
    cin >> R >> B >> C;

    R = min(R, C);
    long long maxtime = 0, mintime = LONG_MAX;
    for (long long i = 0; i < C; i++) {
      long long M, S, P;
      cin >> M >> S >> P;
      cashiers[i].m = M;
      cashiers[i].s = S;
      cashiers[i].p = P;
      maxtime = max(maxtime, S * min(M, B) + P);
      mintime = min(mintime, S + P);
    }

    vector<long long> scanned(C);
    while (maxtime > mintime) {
      long long cand = (maxtime + mintime) / 2;
      for (long long i = 0; i < C; i++) {
        scanned[i] = cashiers[i].compute(cand);
      }
      sort(scanned.begin(), scanned.end());
      
      long long good = 0;
      for (long long i = 0; i < R; i++) {
        long long index = C - 1 - i;
        good += scanned[index];
      }
      if (good >= B) {
        maxtime = cand;
      } else {
        mintime = (cand + 1);
      }
    }

    cout << "Case #" << t << ": " << maxtime << endl;
  }
}
