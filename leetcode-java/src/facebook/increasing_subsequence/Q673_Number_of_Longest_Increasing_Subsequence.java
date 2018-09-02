package facebook.increasing_subsequence;

import java.util.*;

public class Q673_Number_of_Longest_Increasing_Subsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] len = new int[nums.length];
        int[] cnt = new int[nums.length];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (len[i] <= len[j]) {
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    } else if (len[i] == len[j]+1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
        }
        int max_len = Arrays.stream(len).max().getAsInt();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len[i] == max_len) result += cnt[i];
        }
        return result;
    }

}
