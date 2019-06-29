package Y2018.range_query;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Q239_Sliding_Window_Maximum_B {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!Q.isEmpty() && Q.peek() < i - k + 1) {
                Q.poll();
            }
            while (!Q.isEmpty() && nums[Q.peekLast()] < nums[i]) {
                Q.pollLast();
            }
            Q.offer(i);
            if (i >= k - 1) {
                result.add(nums[Q.peek()]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
