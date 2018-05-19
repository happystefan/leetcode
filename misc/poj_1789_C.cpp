#include <cstdio>
#include <climits>
#include <cstring>
#include <iostream>
#include <string>
#include <set>
#include <algorithm>

using namespace std;

const int maxn = 2000 + 10;

char f[maxn][7];
int w[maxn][maxn];

int dist(int a, int b) {
    int result = 0;
    for (int i = 0; i < 7; i++) {
        if (f[a][i] != f[b][i]) {
            result++;
        }
    }
    return result;
}

// Prime algorithm (vanilla)
int main() {
    int N;
    while (~scanf("%d", &N) && N != 0) {
        for (int i = 0; i < N; i++) {
            scanf("%s", &f[i]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                w[i][j] = w[j][i] = dist(i, j);
            }
        }

        set<int> visited;
        visited.insert(0);
        int dist_sum = 0;
        while (visited.size() != N) {
            int next, min_dist = INT_MAX;
            for (set<int>::iterator it = visited.begin(); it != visited.end(); it++) {
                int x = *it;
                for (int y = 0; y < N; y++) {
                    if (visited.find(y) != visited.end()) {
                        continue;
                    }
                    if (w[x][y] < min_dist) {
                        min_dist = w[x][y];
                        next = y;
                    }
                }
            }
            visited.insert(next);
            dist_sum += min_dist;
        }

        printf("The highest possible quality is 1/%d.\n", dist_sum);
    }
}