#include <cstdio>
#include <cstring>

using namespace std;

const int maxn = 30000 + 10;

int p[maxn];

int findp(int x) {
	return p[x] == x ? x : p[x] = findp(p[x]);
}

int main() {
	int n, m, k, x, y;
	while (scanf("%d %d", &n, &m) && (n+m)) {
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		while (m--) {
			scanf("%d %d", &k, &x);
			k -= 1;
			while (k--) {
				scanf("%d", &y);
				int px = findp(x);
				int py = findp(y);
				if (px != py) {
					p[px] = py;
				}
				x = y;
			}
		}
		int p0 = findp(0);
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (findp(i) == p0) {
				result++;
			}
		}
		printf("%d\n", result);
	}
}
