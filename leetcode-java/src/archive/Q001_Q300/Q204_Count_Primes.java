package archive.Q001_Q300;

public class Q204_Count_Primes {

    public int countPrimes(int n) {
        boolean[] notprime = new boolean[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!notprime[i]) {
                ans++;
                for (int j = 2; i*j < n; j++) notprime[i*j] = true;
            }
        }
        return ans;
    }

}
