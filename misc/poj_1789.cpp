#include <cstdio>
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

const int max_len = 2000 + 10;
char f[max_len][7];
int p[max_len];

struct edge {
    int x;
    int y;
    int w;
}edges[max_len*max_len/2];

int dist(int a, int b) {
    int result = 0;
    for (int i = 0; i < 7; i++) {
        if (f[a][i] != f[b][i]) {
            result++;
        }
    }
    return result;
}

bool cmp(edge a, edge b) {
    return a.w < b.w;
}

int findp(int i) {
    return i == p[i] ? i : p[i] = findp(p[i]);
}

// Kruskal algorithm
int main() {
    int N;
    while (~scanf("%d", &N) && N != 0) {
        for (int i = 0; i < N; i++) {
            scanf("%s", &f[i]);
        }

        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                edges[k].x = i;
                edges[k].y = j;
                edges[k].w = dist(i, j);
                k++;
            }
        }

        sort(edges, edges+k, cmp);
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        int dist_sum = 0;
        for (int i = 0; i < k; i++) {
            int a = findp(edges[i].x);
            int b = findp(edges[i].y);
            if (a != b) {
                dist_sum += edges[i].w;
                p[a] = b;
            }
        }
        printf("The highest possible quality is 1/%d.\n", dist_sum);
    }
    return 0;
}