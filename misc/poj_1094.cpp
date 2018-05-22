#include <cstdio>
#include <cstring>
#include <vector>
#include <queue>

using namespace std;

int degree[30];
vector<int> neighb[30];
char order[30];
int n, m;

int topSort() {
    int d[30];
    memcpy(d, degree, sizeof(degree));

    queue<int> Q;
    for (int i = 0; i < n; i++) {
        if (d[i] == 0) {
            Q.push(i);
        }
    }

    int k = 0;
    int flag = 1;
    while (!Q.empty()) {
        if (Q.size() > 1) {
            flag = 0; // uncertain
        }
        int u = Q.front();
        Q.pop();
        order[k++] = u+'A';
        for (vector<int>::iterator it = neighb[u].begin(); it != neighb[u].end(); it++) {
            d[*it]--;
            if (d[*it] == 0) {
                Q.push(*it);
            }
        }
    }
    order[k] = '\0';
    if (k != n) return -1; // circle
    return flag;
}

int main() {
    char u, v;
    while (~scanf("%d %d\n", &n, &m) && (n+m)) {
        memset(degree, 0, sizeof(degree));

        for (int i = 0; i <n; i++) {
            neighb[i].clear();
        }

        int flag = 0;
        for (int i = 0; i < m; i++) {
            scanf("%c<%c\n", &u, &v);

            if (flag != 0) {
                continue;
            }

            u -= 'A';
            v -= 'A';

            neighb[u].push_back(v);
            degree[v]++;

            flag = topSort();
            if(flag == 1) {
                printf("Sorted sequence determined after %d relations: %s.\n", i+1, order);
            } else if(flag == -1) {
                printf("Inconsistency found after %d relations.\n", i+1);
            }
        }
        if(!flag) puts("Sorted sequence cannot be determined.");
    }
}