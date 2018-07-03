package Q001_Q300;

import java.util.PriorityQueue;

public class Q215_Kth_Largest_Element_in_an_Array_B {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) queue.add(num);
        while(queue.size() > k) queue.poll();
        return queue.peek();
    }

}
