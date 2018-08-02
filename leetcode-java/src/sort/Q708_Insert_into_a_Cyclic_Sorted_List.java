package sort;

public class Q708_Insert_into_a_Cyclic_Sorted_List {

    class Node {
        public int val;
        public Node next;
        public Node() {}
        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node result = new Node(insertVal, null);
            result.next = result;
            return result;
        }
        if (head == head.next) {
            if (insertVal > head.val) {
                head.next = new Node(insertVal, head.next);
                return head;
            } else {
                Node result = new Node(insertVal, head);
                head.next = result;
                return result;
            }
        }
        Node walker = head;
        Node runner = head;
        while (runner != null && runner.next != null) {
            if (walker.val > walker.next.val) {
                break;
            }
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                break;
            }
        }
        Node smallest = walker.next;
        walker.next = null;
        Node curr = smallest, prev = null;
        while (curr != null && curr.val < insertVal) {
            prev = curr;
            curr = curr.next;
        }
        if(prev == null || curr == null) {
            walker.next = new Node(insertVal, smallest);
        } else {
            walker.next = smallest;
            prev.next = new Node(insertVal, curr);
        }
        return head;
    }

}
