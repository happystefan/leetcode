package Y2020.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q0659_Split_Array_into_Consecutive_Subsequences {

    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        Arrays.sort(nums);
        PriorityQueue<int[]> Q = new PriorityQueue<>((a, b) ->
                a[1] == b[1] ? (a[1] - a[0]) - (b[1] - b[0]) : a[1] - b[1]);
        for (int num : nums) {
            while (!Q.isEmpty() && Q.peek()[1] + 1 < num) {
                int[] itl = Q.poll();
                if (itl[1] - itl[0] + 1 < 3) return false;
            }
            if (Q.isEmpty() || Q.peek()[1] == num) {
                Q.add(new int[]{num, num});
            } else {
                Q.add(new int[]{Q.poll()[0], num});
            }
        }
        while (!Q.isEmpty()) {
            int[] itl = Q.poll();
            if (itl[1] - itl[0] + 1 < 3) return false;
        }
        return true;
    }

}
