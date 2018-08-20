package archive.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q401_Binary_Watch {

    public List<String> readBinaryWatch(int num) {
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        List<String> ans = new LinkedList<>();
        for (int i = 0; i <= num && i <= nums1.length; i++) {
            Set<Integer> h = new HashSet<>(), m = new HashSet<>();
            dfs(nums1, i, 0, 0, h);
            dfs(nums2, num-i,0, 0,  m);
            for (int hh : h) {
                if (hh >= 12) continue;
                for (int mm : m) {
                    if (mm >= 60) continue;
                    ans.add(String.format("%d:%02d", hh, mm));
                }
            }
        }
        return ans;
    }

    private void dfs(int[] nums, int count, int pos, int sum, Set<Integer> comb) {
        if (count == 0) {
            comb.add(sum);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            dfs(nums, count-1, i+1, sum+nums[i], comb);
            dfs(nums, count, i+1, sum, comb);
        }
    }

}
