package Y2018.linked_list;

import java.util.HashSet;
import java.util.Set;

public class Q817_Linked_List_Components_B {

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        while (head != null && head.next != null) {
            if (set.contains(head.val) && set.contains(head.next.val)) {
                set.remove(head.val);
            }
            head = head.next;
        }

        return set.size();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
