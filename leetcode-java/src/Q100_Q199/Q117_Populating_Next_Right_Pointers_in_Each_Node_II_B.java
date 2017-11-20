package Q100_Q199;

public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II_B {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        if (root.left != null) root.left.next = root.right;
        if (root.next != null) {
            if (root.right != null) {
                if (root.next.left != null) root.right.next = root.next.left;
                else root.right.next = root.next.right;
            } else if (root.left != null) {
                if (root.next.left != null) root.left.next = root.next.left;
                else root.left.next = root.next.right;
            }
        }

        connect(root.left);
        connect(root.right);
    }
}
