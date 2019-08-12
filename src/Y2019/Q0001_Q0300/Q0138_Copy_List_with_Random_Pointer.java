package Y2019.Q0001_Q0300;

import java.util.*;

public class Q0138_Copy_List_with_Random_Pointer {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: iterative
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution1 {

        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node curr = head;
            while (curr != null) {
                Node copy = new Node(curr.val, null, null);
                map.put(curr, copy);
                curr = curr.next;
            }
            for (Node node : map.keySet()) {
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
            }
            return map.get(head);
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    class solution2 {

        Map<Node, Node> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            if (map.containsKey(head)) return map.get(head);
            Node copy = new Node(head.val, null, null);
            map.put(head, copy);
            copy.next = copyRandomList(head.next);
            copy.random = copyRandomList(head.random);
            return copy;
        }

    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 3: O(1) space
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    static class solution3 {

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node curr = head;
            while (curr != null) {
                curr.next = new Node(curr.val, curr.next, null);
                curr = curr.next.next;
            }

            curr = head;
            while (curr != null) {
                curr.next.random = curr.random == null ? null : curr.random.next;
                curr = curr.next.next;
            }

            Node result = head.next;
            curr = result;
            while (head != null) {
                head.next = curr.next;
                curr.next = curr.next == null ? null : curr.next.next;
                head = head.next;
                curr = curr.next;
            }
            return result;
        }

    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

}
