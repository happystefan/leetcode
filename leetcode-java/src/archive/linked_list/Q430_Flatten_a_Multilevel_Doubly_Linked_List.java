package archive.linked_list;

public class Q430_Flatten_a_Multilevel_Doubly_Linked_List {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node() {}
        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node dummy = new Node(0, null, null, null);
        dfs(dummy, head);
        Node result = dummy.next;
        result.prev = null;
        return result;
    }

    private void dfs(Node prev, Node head) {
        if (head == null) {
            prev.next = null;
            return;
        }
        Node next = head.next;
        Node child = head.child;
        head.next = null;
        head.child = null;
        prev.next = head;
        head.prev = prev;

        if (child != null) {
            dfs(prev.next, child);
        }
        while (prev.next != null) {
            prev = prev.next;
        }
        dfs(prev, next);
    }

}
