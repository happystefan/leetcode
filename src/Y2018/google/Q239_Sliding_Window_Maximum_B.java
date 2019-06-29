package Y2018.google;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q239_Sliding_Window_Maximum_B {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[deque.peek()];
            }
        }
        return ans;
    }

}
