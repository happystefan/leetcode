package backtracking;

import java.util.Random;

public class Q382_Linked_List_Random_Node_B {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {

        ListNode head;
        Random random;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            ListNode curr = head;
            ListNode result = head;
            for (int i = 1; curr != null; i++) {
                if (random.nextInt(i) == 0) {
                    result = curr;
                }
                curr = curr.next;
            }
            return result.val;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
