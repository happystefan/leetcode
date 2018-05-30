#include <cstdio>
#include <cstring>

const int maxn = 100000 + 10;

int p[maxn];
int r[maxn];

int findp(int x) {
	if (x == p[x]) {
		return x;
	}
	int px = p[x];
	p[x] = findp(p[x]);
	r[x] = (r[x] + r[px]) % 2;
	return p[x];
}

int main() {
	int T, N, M;
	char o[2];
	int x, y;
	scanf("%d", &T);
	while (T--) {
		scanf("%d %d\n", &N, &M);
		for (int i = 1; i <= N; i++) {
			p[i] = i;
			r[i] = 0;
		}
		while (M--) {
			scanf("%s %d %d", o, &x, &y);
			int px = findp(x);
			int py = findp(y);
			if (o[0] == 'A') {
				if (px == py) {
					if (r[x] == r[y]) {
						puts("In the same gang.");
					} else {
						puts("In different gangs.");
					}
				} else {
					puts("Not sure yet.");
				}
			} else {
				p[px] = py;
 				r[px] = (r[x] + 1 + r[y]) % 2;
			}
		}
	}
}
