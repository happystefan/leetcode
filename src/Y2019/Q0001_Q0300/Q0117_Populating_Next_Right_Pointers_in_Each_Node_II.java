package Y2019.Q0001_Q0300;

public class Q0117_Populating_Next_Right_Pointers_in_Each_Node_II {

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 1: recursive
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public Node connect_rcursive(Node root) {
        if (root == null) return root;
        if (root.left != null) root.left.next = root.right;
        if (root.next != null) {
            Node next = root.next;
            while (next.next != null && next.left == null && next.right == null) next = next.next;
            if (root.right != null) {
                root.right.next = next.left != null ? next.left : next.right;
            } else if (root.left != null) {
                root.left.next = next.left != null ? next.left : next.right;
            }
        }
        connect_rcursive(root.right);
        connect_rcursive(root.left);
        return root;
    }

    /*
     *------------------------------------------------------------------------------------------------------------------
     *
     * solution 2: level order traversal without a Queue. Using a dummy node to link nodes in the same level together.
     *
     *------------------------------------------------------------------------------------------------------------------
     */
    public Node connect(Node root) {
        Node dumy = new Node();
        dumy.next = root;
        while (dumy.next != null) {

            Node newDumy = new Node();
            Node curr = newDumy;

            Node node = dumy.next;
            while (node != null) {
                if (node.left != null) {
                    curr.next = node.left;
                    curr = curr.next;
                }
                if (node.right != null) {
                    curr.next = node.right;
                    curr = curr.next;
                }
                node = node.next;
            }

            dumy = newDumy;
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
