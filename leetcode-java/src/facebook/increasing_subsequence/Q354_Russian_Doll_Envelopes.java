package facebook.increasing_subsequence;

import java.util.*;

public class Q354_Russian_Doll_Envelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b)-> (a[0] == b [0] ? b[1] - a[1] : a[0] - b[0]));
        List<Integer> list = new ArrayList<>();
        for (int[] wh : envelopes) {
            int h = wh[1];
            if (list.size() == 0 || list.get(list.size()-1) < h) list.add(h);
            else list.set(bsearch(list, h), h);
        }
        return list.size();
    }

    private int bsearch(List<Integer> nums, int target) {
        int l = 0, r = nums.size()-1;
        while (l < r) {
            int m = l+(r-l)/2;
            if (nums.get(m) < target) l = m+1;
            else r = m;
        }
        return l;
    }

}
