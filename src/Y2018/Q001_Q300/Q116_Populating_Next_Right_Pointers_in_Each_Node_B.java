package Y2018.Q001_Q300;

public class Q116_Populating_Next_Right_Pointers_in_Each_Node_B {

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        if (root.left != null) root.left.next = root.right;
        if (root.next != null && root.right.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
