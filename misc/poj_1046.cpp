#include <cstdio>
#include <climits>

int main() {
    int rr[16], gg[16], bb[16];
    for (int i = 0; i < 16; i++) {
        scanf("%d %d %d\n", &rr[i], &gg[i], &bb[i]);
    }
    int r, g, b;
    while (~scanf("%d %d %d\n", &r, &g, &b) && (r != -1 && g != -1 && b != -1)) {
        int idx = 0;
        int min_dis = INT_MAX;
        for (int i = 0; i < 16; i++) {
            int dis = (r-rr[i])*(r-rr[i]) + (g-gg[i])*(g-gg[i]) + (b-bb[i])*(b-bb[i]);
            if (dis < min_dis) {
                min_dis = dis;
                idx = i;
            }
        }
        printf("(%d,%d,%d) maps to (%d,%d,%d)\n", r, g, b, rr[idx], gg[idx], bb[idx]);
    }
}