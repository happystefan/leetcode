#include <cstdio>
#include <climits>
#include <cstring>
#include <algorithm>

using namespace std;

const int maxn = 505;
int w[maxn][maxn];
int d[maxn];
int visited[maxn];

int main() {
    int T, N;
    scanf("%d", &T);
    while (T--) {
        scanf("%d", &N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                scanf("%d", &w[i][j]);
            }
        }

        fill(d, d+N, INT_MAX);
        memset(visited, 0, sizeof(visited));

        d[0] = 0;
        int dist_max = 0;
        for (int i = 0; i < N; i++) {
            int x, min_dist = INT_MAX;
            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    continue;
                }
                if (d[j] <= min_dist) {
                    min_dist = d[j];
                    x = j;
                }
            }
            visited[x] = 1;
            dist_max = max(dist_max, d[x]);
            for (int y = 0; y < N; y++) {
                if (visited[y]) {
                    continue;
                }
                d[y] = min(d[y], w[x][y]);
            }
        }
        printf("%d\n", dist_max);
    }
}