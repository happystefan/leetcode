#include <cstdio>
#include <algorithm>

using namespace std;

int sequence_len(int n) {
    int cnt = 1;
    while (n != 1) {
        n = (n % 2 == 1) ? 3 * n + 1 : n / 2;
        cnt++;
    }
    return cnt;
}

int main() {
    int i, j;
    while (~scanf("%d %d", &i, &j)) {
        int result = -1;
        for (int k = min(i, j); k <= max(i, j); k++) {
            result = max(result, sequence_len(k));
        }
        printf("%d %d %d\n", i, j, result);
    }
}
