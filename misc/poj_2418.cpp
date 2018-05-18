#include <cstdio>
#include <map>
#include <string>
#include <iostream>

using namespace std;

int main() {
    string str;
    map<string, int> tree_map;
    int cnt = 0;
    while (getline(cin, str)) {
        tree_map[str]++;
        cnt++;
    }
    for (map<string, int>:: iterator i = tree_map.begin(); i != tree_map.end(); i++) {
        printf("%s %.4f\n", i->first.c_str(), i->second*100.0/cnt);
    }
}