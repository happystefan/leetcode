package facebook;

import java.util.ArrayList;
import java.util.Arrays;

public class Q602_Russian_Doll_Envelopes_B {

    // binary search
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (a, b) -> {
            return a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]);
        });

        ArrayList<Integer> dp = new ArrayList<>();
        for (int[] envelop : envelopes) {
            int l = 0, r = dp.size();
            while (l < r) {
                int m = l+(r-l)/2;
                if (dp.get(m) < envelop[1]) {
                    l = m+1;
                } else {
                    r = m;
                }
            }
            if (r >= dp.size()) {
                dp.add(envelop[1]);
            } else {
                dp.set(r, envelop[1]);
            }
        }
        return dp.size();
    }

}
