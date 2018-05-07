#include <cstdio>

const int max_len = 50;
int dp[max_len][2];

int main() {
    dp[1][0] = 1;
    dp[1][1] = 1;
    for (int i = 2; i < max_len; i++) {
        dp[i][0] = dp[i-1][0] + dp[i-1][1];
        dp[i][1] = dp[i-1][0];
    }

    int t;
    scanf("%d", &t);
    for (int i = 1; i <= t; i++) {
        int n;
        scanf("%d", &n);
        printf("Scenario #%d:\n", i);
        printf("%d\n\n", dp[n][0]+dp[n][1]);
    }
}
