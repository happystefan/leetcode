package linked_list;

import java.util.*;

public class Q817_Linked_List_Components_B {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


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

}
