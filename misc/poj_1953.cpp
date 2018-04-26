#include <cstdio>

int fibonacci(int n) {
    if (n == 1) return 2;
    if (n == 2) return 3;
    int a = 2, b = 3;

    while (n-- > 2) {
        int bb = b;
        b = a + b;
        a = bb;
    }
    return b;
}

int main() {
    int t;
    scanf("%d", &t);
    for (int i = 1; i <= t; i++) {
        int n;
        scanf("%d", &n);
        printf("Scenario #%d:\n", i);
        printf("%d\n\n", fibonacci(n));
    }
}