package misc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q017_Even_Subarray {

    /*
    given a list of numbers (may contains duplication).
    return how many subarray it has with at most k odd numbers
    */
    public int even_Subarray(List<Integer> nums, int k) {
        Set<List<Integer>> set = new HashSet<>();
        /*
        int i = 0, j = 0;
        int cnt = 0;
        while (j < nums.size()) {
            if (nums.get(j++) % 2 == 1) {
                cnt++;
            }
            while (cnt > k) {
                if (nums.get(i++) % 2 == 1) {
                    cnt--;
                }
            }

            for (int idx = i; idx < j; idx++) {
                set.add(nums.subList(idx, j));
            }
        }
        */
        for (int i = 0; i < nums.size(); i++) {
            int cnt = 0;
            int j;
            for (j = i; j < nums.size(); j++) {
                if (nums.get(j) % 2 == 1) {
                    cnt++;
                }
                if (cnt > k) {
                    break;
                }
            }
            for (int idx = i + 1; idx <= j; idx++) {
                System.out.println(nums.subList(i, idx));
                set.add(nums.subList(i, idx));
            }
        }
        return set.size();
    }

}
