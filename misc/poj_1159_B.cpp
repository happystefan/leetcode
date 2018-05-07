#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

const int maxn = 5000+10;
int dp[2][maxn];

// dp + using 2 row arrays
int main() {
    int k;
    string stra;
    while (cin >> k) {
        cin >> stra;
        string strb = string(stra.rbegin(), stra.rend());
        memset(dp, 0, sizeof(dp));

        for (int i = 1; i <= stra.size(); i++) {
            for (int j = 1; j <= strb.size(); j++) {
                if (stra[i-1] == strb[j-1]) {
                    dp[i%2][j] = dp[1-i%2][j-1]+1;
                } else {
                    dp[i%2][j] = max(dp[1-i%2][j], dp[i%2][j-1]);
                };
            }
        }
        cout << stra.size() - dp[stra.size()%2][strb.size()] << endl;
    }

}