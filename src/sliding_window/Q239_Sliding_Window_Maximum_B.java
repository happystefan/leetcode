package sliding_window;

import java.util.ArrayDeque;

public class Q239_Sliding_Window_Maximum_B {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!Q.isEmpty() && Q.peek() < i - k + 1) {
                Q.pollFirst();
            }
            while (!Q.isEmpty() && nums[Q.peekLast()] < nums[i]) {
                Q.pollLast();
            }
            Q.offer(i);
            if (i >= k - 1) {
                result[idx++] = nums[Q.peekFirst()];
            }
        }
        return result;
    }

}
