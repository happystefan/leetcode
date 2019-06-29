package Y2018.tree;

public class Q116_Populating_Next_Right_Pointers_in_Each_Node {

    public void connect(TreeLinkNode root) {
        connect(root, null);
    }

    private void connect(TreeLinkNode root, TreeLinkNode next) {
        if (root == null) {
            return;
        }
        root.next = next;
        connect(root.left, root.right);
        connect(root.right, next == null ? null : next.left);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

}
