#include <cstdio>

int main() {
    int n, s, t;
    while (~scanf("%d", &n) && n != -1) {
        int pre_t = 0;
        int result = 0;
        while (n--) {
            scanf("%d %d", &s, &t);
            result += s * (t - pre_t);
            pre_t = t;
        }
        printf("%d miles\n", result);
    }
}