package archive.google;

public class Q313_Super_Ugly_Number_B {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ans = new int[n+1];
        int[] cnt = new int[primes.length];
        ans[0] = 1;
        int k = 0;
        while (k < n) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < primes.length; i++) {
                if (ans[cnt[i]]*primes[i] < min) {
                    min = ans[cnt[i]]*primes[i];
                    idx = i;
                }
            }
            if (min > ans[k]) ans[++k] = min;
            cnt[idx]++;
        }
        return ans[k-1];
    }

}
