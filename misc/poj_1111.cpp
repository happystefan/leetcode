#include <cstdio>
#include <cstring>

const int maxn = 25;

char m[maxn][maxn];
int visited[maxn][maxn];
int row, col;
int result;

int dirs[8][2] = { {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1} };

void dfs(int x, int y) {
    visited[x][y] = 1;
    for (int i = 0; i < 8; i++) {
        int xx = x + dirs[i][0];
        int yy = y + dirs[i][1];
        if (xx >= 0 && xx < row && yy >= 0 && yy < col) {
            if (m[xx][yy] == 'X' && !visited[xx][yy]) {
                dfs(xx, yy);
            }
            if (m[xx][yy] == '.' && (x == xx || y == yy)) {
                result++;
            }
        } else if (x == xx || y == yy) {
            result++;
        }
    }
}

int main() {
    int x, y;
    while (~scanf("%d %d %d %d\n", &row, &col, &x, &y) && (row+col+x+y)) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                scanf("%c", &m[i][j]);
            }
            getchar();
        }
        memset(visited, 0, sizeof(visited));
        result = 0;
        dfs(x, y);
        printf("%d\n", result);
    }
}
