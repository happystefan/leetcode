package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q003_K_Smallest_Pairs {

    /*
    I found it helpful to visualize the input as an m×n matrix of sums,
    for example for nums1=[1,7,11], and nums2=[2,4,6]:

          2   4   6
       +------------
     1 |  3   5   7
     7 |  9  11  13
    11 | 13  15  17

    Of course the smallest pair overall is in the top left corner,
    the one with sum 3. We don't even need to look anywhere else.
    After including that pair in the output, the next-smaller pair
    must be the next on the right (sum=5) or the next below (sum=9).
    We can keep a "horizon" of possible candidates, implemented as
    a heap / priority-queue, and roughly speaking we'll grow from
    the top left corner towards the right/bottom.
    * */

    // Whenever (i, j) is chosen, add (i+1, j) and (i, j+1) as candidates.
    // caution: deduplicate
    // TC: K*log(N)
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> rslt = new LinkedList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return rslt;
        }
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        Set<String> set = new HashSet<>();
        set.add(0 + " " + 0);
        Q.add(new int[]{0, 0, nums1[0] * nums2[0]});
        while (rslt.size() < k && !Q.isEmpty()) {
            int[] ij = Q.poll();
            int i = ij[0], j = ij[1];
            rslt.add(new int[]{nums1[i], nums2[j]});
            int ii = i + 1, jj = j + 1;
            if (ii < nums1.length && !set.contains(ii + " " + j)) {
                Q.add(new int[]{ii, j, nums1[ii] * nums2[j]});
            }
            if (jj < nums2.length && !set.contains(i + " " + jj)) {
                Q.add(new int[]{i, jj, nums1[i] * nums2[jj]});
            }
        }
        return rslt;
    }

    // O(KlogK) since que.size <= k and we do at most k loop
    public List<int[]> kSmallestPairs_2(int[] nums1, int[] nums2, int k) {
        List<int[]> rslt = new LinkedList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return rslt;
        }
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < nums1.length & i < k; i++) {
            Q.add(new int[]{i, 0, nums1[i] * nums2[0]});
        }
        while (rslt.size() < k && !Q.isEmpty()) {
            int[] ij = Q.poll();
            int i = ij[0], j = ij[1];
            rslt.add(new int[]{nums1[i], nums2[j]});
            j++;
            if (j < nums2.length) Q.add(new int[]{i, j, nums1[i]*nums2[j]});
        }
        return rslt;
    }

}
