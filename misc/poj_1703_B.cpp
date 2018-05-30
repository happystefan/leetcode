#include <cstdio>

const int maxn = 100000 + 10;

int p[maxn*2];
int h[maxn*2];

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
	int T, M, N;
	char c;
	int x, y;
	scanf("%d", &T);
	while (T--) {
		scanf("%d %d\n", &N, &M);
		for (int i = 1; i <= N*2; i++) {
			p[i] = i;
			h[i] = 0;
		}
		while (M--) {
			scanf("%c %d %d\n", &c, &x, &y);
			if (c == 'A') {
				if (findp(x) == findp(y)) {
					puts("In the same gang.");
				} else if (findp(x) == findp(y+N)) {
					puts("In different gangs.");
				} else {
					puts("Not sure yet.");
				}

			} else {
				unite(x, y + N);
				unite(x + N, y);
			}
		}
	}
}
