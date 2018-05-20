#include <cstdio>
#include <cstring>
#include <queue>

using namespace std;

const int maxn = 310;
int m[maxn][maxn];
int visited[maxn][maxn];

int T, N;
int sx, sy, ex, ey;

int dirs[8][2] = {
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2},
        {2, 1},
        {2, -1},
        {-2, 1},
        {-2, -1},
};

int bfs() {
    queue<pair<int, int> > Q;
    Q.push(make_pair(sx, sy));
    visited[sx][sy] = 1;

    int result = 0;
    while (!Q.empty()) {
        int size = Q.size();
        while (size--) {
            int cx = Q.front().first;
            int cy = Q.front().second;
            Q.pop();
            if (cx == ex && cy == ey) {
                return result;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dirs[i][0];
                int ny = cy + dirs[i][1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    Q.push(make_pair(nx, ny));
                    visited[nx][ny] = 1;
                }
            }
        }
        result++;
    }
    return result;
}

int main() {
    scanf("%d", &T);
    while (T--) {
        scanf("%d", &N);
        scanf("%d %d", &sx, &sy);
        scanf("%d %d", &ex, &ey);

        memset(visited, 0, sizeof(visited));
        printf("%d\n", bfs());
    }
}