package archive.google;

import java.util.*;

public class Q163_Missing_Ranges_B {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            long l = i == 0 ? (long)lower : (long)nums[i-1]+1;
            long r = i == nums.length ? (long)upper : (long)nums[i]-1;
            if (l > r) {
                continue;
            }
            if (l == r) {
                result.add(String.valueOf(l));
            } else {
                result.add(String.format("%d->%d", l, r));
            }
        }
        return result;
    }

}
