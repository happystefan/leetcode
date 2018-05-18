#include <cstdio>
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

const int max_len = 100000 + 10;
int nums[max_len];

int main() {
    int N, K;
    scanf("%d", &N);
    for (int i = 0; i <= N; i++) {
        scanf("%d", &nums[i]);
    }

    sort(nums, nums+N);

    string tmp;
    cin >> tmp;
    scanf("%d", &K);
    while(K--) {
        int q;
        scanf("%d", &q);
        printf("%d\n", nums[q-1]);
    }
}