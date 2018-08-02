package misc;

import java.util.*;

public class Q013_Radix_Sort {

    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int[] sorted = new int[nums.length];
        int max = Arrays.stream(nums).max().getAsInt();
        int exp = 1;
        while (max/exp > 0) { // Go through all digits from LSB to MSB
            int[] cnt = new int[10];
            for (int i = 0; i < nums.length; i++) {
                cnt[(nums[i]/exp)%10]++;
            }
            for (int i = 1; i < cnt.length; i++) {
                cnt[i] += cnt[i-1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                sorted[--cnt[(nums[i]/exp)%10]] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sorted[i];
            }
            exp *= 10;
        }
    }

}
