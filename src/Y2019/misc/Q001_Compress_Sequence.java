package Y2019.misc;

import java.util.LinkedList;
import java.util.List;

public class Q001_Compress_Sequence {
    /*
    Given a monotone increasing array, compress all continuous part as [start, end], example:
    input: [1, 2, 3, 4, 5, 7, 8, 10, 11, 15]
    output:[ [1, 5], [7, 8], [10, 11], [15, 15] ]
    */

    // solution 1: binary search
    public List<int[]> compressSequence_BS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return doCompressSequence(nums, 0, nums.length - 1);
    }

    private List<int[]> doCompressSequence(int[] nums, int l, int r) {
        List<int[]> result = new LinkedList<>();
        if (l > r) {
            return result;
        }
        if (r - l == nums[r] - nums[l]) {
            result.add(new int[]{nums[l], nums[r]});
            return result;
        }
        int m = l + (r - l) / 2;
        int ll = bsearch_l(nums, l, m);
        int rr = bsearch_r(nums, m, r);
        result.addAll(doCompressSequence(nums, l, ll - 1));
        result.add(new int[]{nums[ll], nums[rr]});
        result.addAll(doCompressSequence(nums, rr + 1, r));
        return result;
    }

    private int bsearch_l(int[] nums, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (r - m == nums[r] - nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private int bsearch_r(int[] nums, int l, int r) {
        while (l < r) {
            int m = r - (r - l) / 2;
            if (m - l == nums[m] - nums[l]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    // solution 2: divide and conquer
    public List<int[]> compressSequence_DC(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return doCompressSequence_DC(nums, 0, nums.length - 1);
    }

    private List<int[]> doCompressSequence_DC(int[] nums, int l, int r) {
        List<int[]> result = new LinkedList<>();
        if (l > r) {
            return result;
        }
        if (r - l == nums[r] - nums[l]) {
            result.add(new int[]{nums[l], nums[r]});
            return result;
        }
        int m = l + (r - l) / 2;
        List<int[]> lresult = doCompressSequence_DC(nums, l, m);
        List<int[]> rresult = doCompressSequence_DC(nums, m + 1, r);
        return merge(lresult, rresult);
    }

    private List<int[]> merge(List<int[]> l, List<int[]> r) {
        if (l == null || l.size() == 0) return r;
        if (r == null || r.size() == 0) return l;
        List<int[]> result = new LinkedList<>();
        int[] ll = l.get(l.size()-1);
        int[] rr = r.get(0);
        if (ll[1] + 1 == rr[0]) {
            l.remove(l.size()-1);
            r.remove(0);
            result.addAll(l);
            result.add(new int[]{ll[0], rr[1]});
            result.addAll(r);
        } else {
            result.addAll(l);
            result.addAll(r);
        }
        return result;
    }

}
