package sliding_window;

import java.util.*;

public class Q239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> Q = new PriorityQueue<>((a, b)->b-a);
        for (int i = 0; i < k; i++) {
            Q.offer(nums[i]);
        }
        int[] result = new int[nums.length-k+1];
        result[0] = Q.peek();
        for (int i = k; i < nums.length; i++) {
            Q.remove(nums[i-k]);
            Q.offer(nums[i]);
            result[i-k+1] = Q.peek();
        }
        return result;
    }

}
