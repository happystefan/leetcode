package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q518_Super_Ugly_Number {

    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> table = new ArrayList<>();
        table.add(1);
        int[] cnt = new int[primes.length];

        while (table.size() < n) {
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < primes.length; i++) {
                if (table.get(cnt[i])*primes[i] < min) {
                    min = table.get(cnt[i]) * primes[i];
                    idx = i;
                }
            }
            if (min > table.get(table.size()-1)) table.add(min);
            cnt[idx]++;
        }

        return table.get(n-1);
    }

}
