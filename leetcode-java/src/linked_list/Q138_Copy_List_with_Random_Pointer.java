package linked_list;

import java.util.*;

public class Q138_Copy_List_with_Random_Pointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        RandomListNode result = new RandomListNode(head.label);
        map.put(head, result);
        result.next = copyRandomList(head.next);
        result.random = copyRandomList(head.random);
        return result;
    }

}
