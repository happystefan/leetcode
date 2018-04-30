#include <cstdio>
#include <cstring>
#include <algorithm>

using namespace std;

int marbles[7];
int dp[10001*6];

// dp
int main() {
    int t = 1;
    while (1) {
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            scanf("%d", &marbles[i]);
            sum += i * marbles[i];
        }
        if (sum == 0) {
            return 0;
        }

        printf("Collection #%d:\n", t++);

        if (sum % 2 == 1) {
            printf("Can't be divided.\n\n");
            continue;
        }

        memset(dp, 0, sizeof(dp));
        for (int i = 1; i <= 6; i++) { // complete knapsack
            if (marbles[i]*i >= sum/2) {
                for (int j = i; j <= sum/2; j++) {
                    dp[j] = max(dp[j], dp[j-i]+i);
                }
            } else { // 0-1 knapsack
                int k = 1, kk = marbles[i];
                while (k < kk) {
                    for (int j = sum/2; j >= k*i; j--) {
                        dp[j] = max(dp[j],dp[j-k*i]+k*i);
                    }
                    kk -= k;
                    k *= 2;
                }
                for (int j = sum/2; j >= kk*i; j--) {
                    dp[j] = max(dp[j],dp[j-kk*i]+kk*i);
                }
            }
        }
        printf("Can%s be divided.\n\n", dp[sum/2] == sum/2 ? "" : "'t");
    }

}
