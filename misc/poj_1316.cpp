#include <cstdio>
#include <cstring>

int const n = 10000;
bool f[n] = {false};

int sum(int n) {
    int result = 0;
    while (n != 0) {
        result += n%10;
        n /= 10;
    }
    return result;
}

int main() {
    for (int i = 1; i < n; i++) {
        if (f[i]) {
            continue;
        }
        int j = i;
        while (j < n) {
            int next_j = j+sum(j);
            f[next_j] = true;
            j = next_j;
        }
    }
    for (int i = 1; i < n; i++) {
        if (f[i]) {
            continue;
        }
        printf("%d\n", i);
    }
    return 0;
}