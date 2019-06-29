package Y2018.facebook;

public class Q426_Convert_Binary_Search_Tree_to_Sorted_Doubly_Linked_List {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        Node l = treeToDoublyList(root.left);
        Node r = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return concatenate(concatenate(l, root), r);
    }

    private Node concatenate(Node l, Node r) {
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        Node llast = l.left;
        Node rlast = r.left;

        llast.right = r;
        r.left = llast;

        l.left = rlast;
        rlast.right = l;

        return l;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
