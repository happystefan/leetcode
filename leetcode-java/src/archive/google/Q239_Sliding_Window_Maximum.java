package archive.google;

import java.util.PriorityQueue;

public class Q239_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        PriorityQueue<Integer> pqueue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            pqueue.add(nums[i]);
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = pqueue.peek();
        for (int i = k; i < nums.length; i++) {
            pqueue.remove(nums[i-k]);
            pqueue.add(nums[i]);
            ans[i-k+1] = pqueue.peek();
        }
        return ans;
    }

}
