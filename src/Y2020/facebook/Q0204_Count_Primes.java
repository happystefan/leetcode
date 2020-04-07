package Y2020.facebook;

import java.util.Arrays;

public class Q0204_Count_Primes {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 2];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i + i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        int rslt = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime[i]) rslt++;
        }
        return rslt;
    }

}
