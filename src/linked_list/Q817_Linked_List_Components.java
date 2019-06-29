package linked_list;

import java.util.HashSet;
import java.util.Set;

public class Q817_Linked_List_Components {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        int result = 0;
        boolean start = false;
        while (head != null) {
            if (set.contains(head.val)) {
                start = true;
            } else {
                if (start) {
                    result++;
                    start = false;
                }
            }
            head = head.next;
        }
        if (start) {
            result++;
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
