package google;

import java.util.Random;

public class Q382_Linked_List_Random_Node {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {

        int len = 0;
        ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            while (head != null) {
                len++;
                head = head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int r = new Random().nextInt(len);
            ListNode ans = head;
            while (r-- != 0) {
                ans = ans.next;
            }
            return ans.val;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
