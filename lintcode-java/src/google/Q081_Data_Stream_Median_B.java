package google;

import java.util.PriorityQueue;

public class Q081_Data_Stream_Median_B {

    public int[] medianII(int[] nums) {
        // write your code here
        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> y-x);
        int[] ans = new int[nums.length];
        int k = 0;
        for (int num : nums) {
            max.offer(num);
            min.offer(max.poll());
            if (max.size() < min.size()) {
                max.offer(min.poll());
            }
            ans[k++] = max.peek();
        }
        return ans;
    }

}
