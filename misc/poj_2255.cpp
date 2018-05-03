#include <iostream>
#include <string>

using namespace std;

string pre_order, in_order;

void gao(int root, int left, int right) {
    if (left > right) {
        return;
    }
    int i;
    for (i = left; i <= right && pre_order[root] != in_order[i]; i++);
    gao(root + 1, left, i - 1);
    gao(root + i - left + 1, i + 1, right);
    cout << in_order[i];
}

int main() {
    while (cin >> pre_order >> in_order) {
        gao(0, 0, pre_order.size()-1);
        cout << endl;
    }
}