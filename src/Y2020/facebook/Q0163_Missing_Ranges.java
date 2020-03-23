package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0163_Missing_Ranges {

    class solution1_brute_force {

        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> rslt = new LinkedList<>();
            for (int i = 0; i <= nums.length; i++) {
                long l = i == 0 ? (long) lower : (long) nums[i - 1] + 1;
                long r = i == nums.length ? (long) upper : (long) nums[i] - 1;
                if (l > r) {
                    continue;
                }
                String missing = l == r ? "" + l : l + "->" + r;
                rslt.add(missing);
            }
            return rslt;
        }

    }

    class solution_bsearch {

        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<Long> list = new LinkedList<>();
            list.add((long) lower - 1);
            for (int num : nums) if (num != list.get(list.size() - 1)) list.add((long) num);
            if (upper != list.get(list.size() - 1)) list.add((long) upper + 1);
            long[] new_nums = list.stream().mapToLong(Long::longValue).toArray();

            List<String> rslt = new LinkedList<>();
            int l = 0;
            while (l < new_nums.length) {
                int r = bsearch(new_nums, l);
                if (r == new_nums.length - 1) break;
                long ll = new_nums[r] + 1;
                long rr = new_nums[r + 1] - 1;
                String missing = ll == rr ? "" + ll : ll + "->" + rr;
                rslt.add(missing);
                l = r + 1;
            }
            return rslt;
        }

        private int bsearch(long[] nums, int i) {
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
