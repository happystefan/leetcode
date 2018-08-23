package facebook;

import java.util.PriorityQueue;

public class Q703_Kth_Largest_Element_in_a_Stream {

    class KthLargest {

        PriorityQueue<Integer> Q = new PriorityQueue<>();
        int size;
        public KthLargest(int k, int[] nums) {
            size = k;
            for (int num : nums) {
                Q.offer(num);
                if (Q.size() > k) Q.poll();
            }
        }

        public int add(int val) {
            Q.offer(val);
            if (Q.size() > size) Q.poll();
            return Q.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

}
