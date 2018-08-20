package archive.tree;

public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dum = new TreeLinkNode(0);
            TreeLinkNode cur = dum;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = dum.next;
        }

        return;
    }

}
