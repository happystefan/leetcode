#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>

using namespace std;

const int maxn = 105;
string str_a[maxn];
string str_b[maxn];

int dp[maxn][maxn];

void dfs(int i, int j, bool first_call) {
    if (i == 0 || j == 0) {
        return;
    }
    if (str_a[i] == str_b[j]) {
        dfs(i-1, j-1, false);
        cout << str_a[i] << (first_call ? "\n" : " ");
    } else {
        if (dp[i-1][j] > dp[i][j-1]) {
            dfs(i-1, j, false);
        } else {
            dfs(i, j-1, false);
        }
    }
}

int main() {
    string str;
    while (cin >> str) {

        int m = 0;
        int n = 0;

        if (str != "#") {
            str_a[++m] = str;
            while (cin >> str && str != "#") {
                str_a[++m] = str;
            }
        }
        while (cin >> str && str != "#") {
            str_b[++n] = str;
        }

        memset(dp, 0, sizeof(dp));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str_a[i] == str_b[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        dfs(m, n, true);
    }
}
