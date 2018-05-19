#include <cstdio>
#include <algorithm>

using namespace std;

const int maxn = 505;

struct edge {
    int x;
    int y;
    int w;
} edges[maxn*maxn/2];

int p[maxn];

int findp(int i) {
    return i == p[i] ? i : p[i] = findp(p[i]);
}

bool cmp(edge a, edge b) {
    return a.w < b.w;
}

int main() {
    int T, N;
    scanf("%d", &T);
    while (T--) {
        scanf("%d", &N);
        int w, k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                scanf("%d", &w);
                if (j > i) {
                    edges[k].x = i;
                    edges[k].y = j;
                    edges[k].w = w;
                    k++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        sort(edges, edges+k, cmp);

        int dist_max = 0;
        for (int i = 0; i < k; i++) {
            int a = findp(edges[i].x);
            int b = findp(edges[i].y);
            if (a != b) {
                dist_max = edges[i].w;
                p[a] = b;
            }
        }
        printf("%d\n", dist_max);
    }
}