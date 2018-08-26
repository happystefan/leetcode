package facebook.mono_queue;

import java.util.*;

public class Q239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int[] result = new int[nums.length-k+1];
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
           while (!Q.isEmpty() && Q.peekFirst() < i-k+1) Q.pollFirst();
           while (!Q.isEmpty() && nums[i] > nums[Q.peekLast()]) Q.pollLast();
           Q.offer(i);
           if (i >= k-1) result[i-k+1] = nums[Q.peekFirst()];
        }
        return result;
    }

}
