#include <cstdio>
#include <set>

using namespace std;

const int max_len = 500010;
int f[max_len];
set<int> num_set;

int main() {
    f[0] = 0;
    num_set.insert(0);
    for (int i = 1; i < max_len; i++) {
        f[i] = f[i-1]-i > 0 && num_set.find(f[i-1]-i) == num_set.end() ? f[i-1]-i : f[i-1]+i;
        num_set.insert(f[i]);
    }

    int k;
    while (~scanf("%d", &k) && k != -1) {
        printf("%d\n", f[k]);
    }
}