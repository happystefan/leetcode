package google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q315_Count_of_Smaller_Numbers_After_Self {

    public List<Integer> countSmaller(int[] nums) {
        List ans = new LinkedList();
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = findIdx(sorted, nums[i]);
            ans.add(0, idx);
            sorted.add(idx, nums[i]);
        }
        return ans;
    }

    private int findIdx(List<Integer> sorted, int num) {
        if (sorted.size() == 0) return 0;
        int l = 0, r = sorted.size();
        if (sorted.get(0) >= num) return 0;
        if (sorted.get(sorted.size() - 1) < num) return sorted.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (sorted.get(m) < num) l = m + 1;
            else r = m;
        }
        return l;
    }

}
