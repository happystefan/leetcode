package linked_list;

import java.util.*;

public class Q817_Linked_List_Components {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

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

}
