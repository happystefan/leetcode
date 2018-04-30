#include <cstdio>
#include <algorithm>

using namespace std;

int marbles[7];

void dfs(int left, bool* result) {
    if (left == 0) {
        *result = true;
        return;
    }
    for (int i = 6; i >= 1; i--) {
        if (marbles[i] && i <= left) {
            marbles[i]--;
            dfs(left - i, result);
        }
    }
}

// dfs
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

        bool result = false;
        dfs(sum/2, &result);
        printf("Can%s be divided.\n\n", result ? "" : "'t");
    }

}
