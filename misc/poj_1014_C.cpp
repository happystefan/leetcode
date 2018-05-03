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
        for (int i = 1; i <= 6; ++i) {
            int left = marbles[i];
            for (int j = 1; j <= left; left -= j, j *= 2)
                for (int k = sum/2; k - i*j >= 0; --k)
                    dp[k] = max(dp[k], dp[k-i*j] + i*j);
            for (int j = 0; j < left; ++j)
                for (int k = sum/2; k - i >= 0; --k)
                    dp[k] = max(dp[k], dp[k-i] + i);
        }
        printf("Can%s be divided.\n\n", dp[sum/2] == sum/2 ? "" : "'t");
    }

}
