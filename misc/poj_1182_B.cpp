#include <cstdio>

const int maxn = 50000 + 10;

int p[maxn*3];
int h[maxn*3];

int findp(int x) {
	return x == p[x] ? x : p[x] = findp(p[x]);
}

void unite(int x, int y) {
	x = findp(x);
	y = findp(y);
	if (x == y) {
		return;
	}
	if (h[x] < h[y]) {
		p[x] = y;
	} else {
		p[y] = x;
		if (h[x] == h[y]) {
			h[x]++;
		}
	}
}

int main() {
	int N, K;
	int c, x, y;
	scanf("%d %d", &N, &K);
	for (int i = 0; i <= 3*N; i++) {
		p[i] = i;
		h[i] = 0;
	}
	int result = 0;
	while (K--) {
		scanf("%d %d %d", &c, &x, &y);
		if (x < 1 || x > N || y < 1 || y > N) {
			result++;
			continue;
		}
		if (c == 1) {
			if (findp(x) == findp(y+N) || findp(x) == findp(y+2*N)) {
				result++;
			} else {
				unite(x, y);
				unite(x+N, y+N);
				unite(x+2*N, y+2*N);
			}
		} else {
			if (findp(x) == findp(y) || findp(x) == findp(y+2*N) ||
			    findp(x+N) == findp(y+N) || findp(x+N) == findp(y) ||
                findp(x+2*N) == findp(y+2*N) || findp(x+2*N) == findp(y+N)) {
				result++;
			} else {
				unite(x, y+N);
				unite(x+N, y+2*N);
				unite(x+2*N, y);
			}
		}
	}
	printf("%d\n", result);
}