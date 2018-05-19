#include <cstdio>
#include <climits>
#include <cstring>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

const int maxn = 2000 + 10;

string f[maxn];
int w[maxn][maxn];
int d[maxn];
int visit[maxn];

int dist(int a, int b) {
    int result = 0;
    for (int i = 0; i < 7; i++) {
        if (f[a][i] != f[b][i]) {
            result++;
        }
    }
    return result;
}

// Prime algorithm
int main() {
    int N;
    while (~scanf("%d", &N) && N != 0) {
        for (int i = 0; i < N; i++) {
            cin >> f[i];
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                w[i][j] = w[j][i] = dist(i, j);
            }
        }
        fill(d, d+N, INT_MAX);
        memset(visit, 0, sizeof(visit));
        d[0] = 0;
        int dist_sum = 0;
        for (int i = 0; i < N; i++) {
            int x, min_dist = INT_MAX;
            for (int y = 0; y < N; y++) {
                if (visit[y]) {
                    continue;
                }
                if (d[y] <= min_dist) {
                    min_dist = d[y];
                    x = y;
                }
            }
            visit[x] = 1;
            dist_sum += d[x];
            for (int y = 0; y < N; y++) {
                if (visit[y]) {
                    continue;
                }
                d[y] = min(d[y], w[x][y]);
            }
        }
        printf("The highest possible quality is 1/%d.\n", dist_sum);
    }
}