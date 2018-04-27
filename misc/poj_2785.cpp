#include <cstdio>
#include <unordered_map>

using namespace std;

int main() {
    int a[4000], b[4000], c[4000], d[4000];
    int n;
    scanf("%d\n", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d %d %d %d\n", &a[i], &b[i], &c[i], &d[i]);
    }
    unordered_map<int, int> map_ab;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            map_ab[a[i]+b[j]]++;
        }
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            result += map_ab[-c[i]-d[j]];
        }
    }
    printf("%d\n", result);

}