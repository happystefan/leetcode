package Y2018.google;

import java.util.LinkedList;
import java.util.List;

public class Q313_Super_Ugly_Number {

    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        int[] cnt = new int[primes.length];
        while (list.size() < n) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < primes.length; i++) {
                if (list.get(cnt[i]) * primes[i] < min) {
                    min = list.get(cnt[i]) * primes[i];
                    idx = i;
                }
            }
            if (min > list.get(list.size() - 1)) list.add(min);
            cnt[idx]++;
        }
        return list.get(n - 1);
    }

}
