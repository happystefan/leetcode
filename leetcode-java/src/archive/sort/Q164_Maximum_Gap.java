package archive.sort;

import java.util.*;

public class Q164_Maximum_Gap {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] sorted = new int[nums.length];
        int max = Arrays.stream(nums).max().getAsInt();
        int exp = 1;
        while (max/exp > 0) { // Go through all digits from LSB to MSB
            int[] cnt = new int[10];
            for (int i = 0; i < nums.length; i++) {
                cnt[(nums[i] / exp) % 10]++;
            }
            for (int i = 1; i < cnt.length; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                sorted[--cnt[(nums[i] / exp) % 10]] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sorted[i];
            }
            exp *= 10;
        }
        int result = 0;
        for (int i = 1; i < sorted.length; i++) {
            result = Math.max(result, sorted[i] - sorted[i - 1]);
        }
        return result;
    }

}
