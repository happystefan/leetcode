#include <cstdio>
#include <iostream>

using namespace std;

int m[4][4];
int dirs[4][2] = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
};

bool is_done() {
    int sum = 0;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            sum += m[i][j];
        }
    }
    return sum % 16 == 0;
}

void flip(int s) {
    int x = s/4, y = s%4;
    m[x][y] = !m[x][y];
    for (int i = 0; i < 4; i++) {
        int xx = x + dirs[i][0];
        int yy = y + dirs[i][1];
        if (xx < 0 || xx >= 4 || yy < 0 || yy >= 4) {
            continue;
        }
        m[xx][yy] = !m[xx][yy];
    }
}

void dfs(int s, int cnt, int* max_cnt) {
    if (is_done()) {
        if (cnt < *max_cnt) {
            *max_cnt = cnt;
            return;
        }
    }
    if (s >= 16) {
        return;
    }

    { // case 1: // not flip s;
        dfs(s + 1, cnt, max_cnt);
    }
    { // case 2: // flip s;
        flip(s);
        dfs(s + 1, cnt + 1, max_cnt);
        flip(s);
    }
}

int main() {
    char c;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> c;
            m[i][j] = c == 'w' ? 1 : 0;
        }
    }

    int max_cnt = 33;
    dfs(0, 0, &max_cnt);
    if (max_cnt == 33) {
        puts("Impossible");
    } else {
        printf("%d\n", max_cnt);
    }
}