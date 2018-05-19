#include <cstdio>
#include <iostream>
#include <queue>

using namespace std;

const unsigned int full_black = (1<<16)-1;
const unsigned int full_white = 0;

int dp[(1<<16)+10] = {0};

unsigned int flip(unsigned int bits, int pos) {
    bits ^= (1<<pos);
    if (pos-4 >= 0) bits ^= (1 << (pos-4));
    if (pos+4 < 16) bits ^= (1 << (pos+4));
    if (pos%4 >= 1) bits ^= (1 << (pos-1));
    if (pos%4 <= 2) bits ^= (1 << (pos+1));
    return bits;
}

int bfs(unsigned int bits) {
    queue<unsigned int> Q;
    Q.push(bits);
    while (!Q.empty()) {
        unsigned int curr_bits = Q.front();
        Q.pop();
        if (curr_bits == full_white || curr_bits == full_black) {
            return dp[curr_bits];
        }
        for (int i = 0; i < 16; i++) {
            unsigned next_bits = flip(curr_bits, i);
            if (dp[next_bits]) {
                continue;
            }
            dp[next_bits] = dp[curr_bits] + 1;
            Q.push(next_bits);
        }
    }
    return -1;
}

int main() {
    unsigned int bits = 0;
    char c;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cin >> c;
            bits <<= 1;
            bits |= c == 'b' ? 1 : 0;
        }
    }

    int ans = bfs(bits);
    if (ans == -1) {
        puts("Impossible");
    } else {
        printf("%d\n", ans);
    }
}