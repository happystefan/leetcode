package Y2018.linked_list;

public class Q430_Flatten_a_Multilevel_Doubly_Linked_List_B {

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            Node child = curr.child;
            while (child.next != null) {
                child = child.next;
            }
            child.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = child;
            }
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

}
