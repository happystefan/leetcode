#include <cstdio>

int main() {

    double balance;
    double sum = 0;
    while (scanf("%lf", &balance) != EOF) {
        sum += balance;
    }
    printf("$%.2f", sum/12);
    return 0;
    
}
