package Y2018.linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class Q713_Subarray_Product_Less_Than_K_B {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int product = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            while (product * nums[i] >= k && !queue.isEmpty()) {
                product /= queue.peek();
                queue.poll();
            }
            if (product * nums[i] < k) {
                product *= nums[i];
                queue.offer(nums[i]);
            }
            result += queue.size();
        }
        return result;
    }

}
