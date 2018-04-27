#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int a[4000], b[4000], c[4000], d[4000];
    int n;
    scanf("%d\n", &n);
    for (int i = 0; i < n; i++) {
        scanf("%d %d %d %d\n", &a[i], &b[i], &c[i], &d[i]);
    }

    vector<int> sum_ab;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            sum_ab.push_back(a[i]+b[j]);
        }
    }
    sort(sum_ab.begin(), sum_ab.end());

    int result = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            result += upper_bound(sum_ab.begin(), sum_ab.end(), -c[i]-d[j]) - lower_bound(sum_ab.begin(), sum_ab.end(), -c[i]-d[j]);
        }
    }
    printf("%d\n", result);

}