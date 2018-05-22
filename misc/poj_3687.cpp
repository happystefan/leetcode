#include <cstdio>
#include <cstring>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>

using namespace std;

int T, N, M;
int degree[210];
int connect[210][210];
int order[210];

int main() {
    scanf("%d", &T);
    while (T--) {
        scanf("%d %d", &N, &M);
        memset(degree, 0, sizeof(degree));
        memset(connect, 0, sizeof(connect));
        while (M--) {
            int u, v;
            scanf("%d %d", &u, &v);
            if (connect[u][v] == 0) { // deduplication
                degree[u]++;
                connect[u][v] = 1;
            }
        }

        priority_queue<int> Q;
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                Q.push(i);
            }
        }

        int k = N;
        while (!Q.empty()) {
            int u = Q.top();
            Q.pop();
            order[u] = k--;

            for (int i = 1; i <= N; i++) {
               if (connect[i][u] > 0) {
                    degree[i]--;
                    connect[i][u] = 0;
                    if (degree[i] == 0) {
                        Q.push(i);
                    }
              }
            }
        }

        if (k != 0) {
            puts("-1");
        } else {
            for (int i = 1; i <= N; i++) {
                printf("%d%c", order[i], i == N ? '\n' : ' ');
            }
        }
    }

}