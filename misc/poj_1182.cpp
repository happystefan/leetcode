#include <cstdio>

const int maxn = 50000 + 10;

int p[maxn]; // lookup table for parent
int r[maxn]; // lookup table for relationship with parent: 0 - same class; 1 - parent eat child; 2 - child eat parent

int findp(int x) {
    if(x == p[x]) return x;
    int px = p[x];
    p[x] = findp(p[x]);
    r[x] = (r[x] + r[px]) % 3; // update relationship
    return p[x];
}

int main() {
    int N, K;
    int o, x, y;
    scanf("%d %d", &N, &K);

    for (int i = 0; i < N; i++) {
        p[i] = i;
        r[i] = 0;
    }

    int result = 0;
    while (K--) {
        scanf("%d %d %d", &o, &x, &y);
        if (x > N || y > N || (o == 2 && x == y)) {
            result++;
            continue;
        }

        int px = findp(x), py = findp(y);
        if (px == py) { // can determine the relationship
            if (o == 1 && r[x] != r[y]) {
                result++;
            }
            if (o == 2 && (r[x]+1)%3 != r[y]) {
                result++;
            }
        } else {
            p[py] = px;
            r[py] = (r[x]-r[y]+3+(o-1))%3; // update relationship
        }
    }
    printf("%d\n", result);

}