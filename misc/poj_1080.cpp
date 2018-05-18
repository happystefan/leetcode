#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int char_to_int(char i) {
    switch (i) {
        case 'A':
            return 0;
        case 'C':
            return 1;
        case 'G':
            return 2;
        case 'T':
            return 3;
        case '-':
            return 4;
    }
    return 0;
}

int scores_table[5][5] = {
        {5, -1, -2, -1, -3},
        {-1, 5, -3, -2, -4},
        {-2, -3, 5, -2, -2},
        {-1, -2, -2, 5, -1},
        {-3, -4, -2, -1, 0},
};

int get_score(char a, char b) {
    return scores_table[char_to_int(a)][char_to_int(b)];
}

const int max_len = 100+5;
int dp[max_len][max_len];

int main() {
    int t;
    string str1, str2;
    int len1, len2;
    scanf("%d", &t);
    while (t--) {
        cin >> len1 >> str1 >> len2 >> str2;

        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i-1][0] + get_score(str1[i-1], '-');
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = dp[0][i-1] + get_score('-', str2[i-1]);
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = max(dp[i-1][j] + get_score(str1[i-1], '-'),
                               max(dp[i][j-1] + get_score('-', str2[j-1]), dp[i-1][j-1] + get_score(str1[i-1], str2[j-1])));
            }
        }

        cout << dp[str1.size()][str2.size()] << endl;
    }
}