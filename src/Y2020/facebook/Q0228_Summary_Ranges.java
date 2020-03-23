package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0228_Summary_Ranges {

    class solution_brute_force {

        public List<String> summaryRanges(int[] nums) {
            List<String> rslt = new LinkedList<>();
            int l = 0;
            while (l < nums.length) {
                int r = l;
                while (r + 1 < nums.length && nums[r + 1] == nums[r] + 1) r++;
                String range = l == r ? "" + nums[l] : nums[l] + "->" + nums[r];
                rslt.add(range);
                l = r + 1;
            }
            return rslt;
        }

    }

    class solution_bsearch {

        public List<String> summaryRanges(int[] nums) {
            List<String> rslt = new LinkedList<>();
            int l = 0;
            while (l < nums.length) {
                int r = bsearch(nums, l);
                if (l == r) rslt.add("" + nums[l]);
                else rslt.add(nums[l] + "->" + nums[r]);
                l = r + 1;
            }
            return rslt;
        }

        private int bsearch(int[] nums, int i) {
            int l = i, r = nums.length - 1;
            while (l < r) {
                int m = r - (r - l) / 2;
                if (nums[m] - nums[i] != m - i) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            return l;
        }

    }

}
