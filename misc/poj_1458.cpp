#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>

using namespace std;

int main() {
    string str_a, str_b;
    while (cin >> str_a >> str_b) {
        int m = str_a.size(), n = str_b.size();
        int dp[m+1][n+1];
        memset(dp, 0, sizeof(dp));
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j++) {
                if (str_a[i-1] == str_b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        cout << dp[m][n] << endl;
    }
}