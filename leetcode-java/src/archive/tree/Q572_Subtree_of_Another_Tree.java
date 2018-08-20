package archive.tree;

public class Q572_Subtree_of_Another_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSameTree(s, t) || s != null && (isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        return s != null && t != null && s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right,  t.right);
    }

}
