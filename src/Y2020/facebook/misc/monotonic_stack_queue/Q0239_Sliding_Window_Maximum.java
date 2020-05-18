package Y2020.facebook.misc.monotonic_stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Q0239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] rslt = new int[nums.length - k + 1];
        Deque<Integer> Q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!Q.isEmpty() && Q.peekFirst() < i - k + 1) Q.pollFirst();
            while (!Q.isEmpty() && nums[Q.peekLast()] <= nums[i]) Q.pollLast();
            Q.addLast(i);
            if (i - k + 1 >= 0) rslt[i - k + 1] = nums[Q.peekFirst()];
        }
        return rslt;
    }

}
