package Y2020.facebook.bsearch;

import java.util.Arrays;

public class Q0875_Koko_Eating_Bananas {

    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            int m = l + (r - l) / 2;
            boolean p = isPossible(piles, H, m);
            if (!p) l = m + 1;
            else r = m;
        }
        return l;
    }

    private boolean isPossible(int[] piles, int H, int K) {
        int h = 0;
        for (int p : piles) {
            h += p / K;
            if (p % K != 0) h++;
        }
        return h <= H;
    }

}
