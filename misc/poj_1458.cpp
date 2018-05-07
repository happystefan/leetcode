#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string str_a, str_b;
    while (cin >> str_a >> str_b) {
        int m = str_a.size(), n = str_b.size();
        int dp[m+1][n+1];
        for (int i = 0; i <= m; i ++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str_a[i-1] == str_b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        cout << dp[m][n] << endl;
    }
}