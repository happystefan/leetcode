#include <cstdio>

int main() {
    float c;
    while (~scanf("%f", &c) && c != 0) {
        float len = 0;
        int cnt;
        for (cnt = 2; len <= c; cnt++) {
            len += 1.0/cnt;
        }
        printf("%d card(s)\n", cnt-2);
    }
}