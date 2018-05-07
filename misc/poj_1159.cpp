#include <cstdio>
#include <cstring>
#include <iostream>

using namespace std;

const int maxn = 5000+10;
short dp[maxn][maxn];

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
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                };
            }
        }
        cout << stra.size() - dp[stra.size()][strb.size()] << endl;
    }

}