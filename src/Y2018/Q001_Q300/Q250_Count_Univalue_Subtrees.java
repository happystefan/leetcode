package Y2018.Q001_Q300;

public class Q250_Count_Univalue_Subtrees {

    int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        traverse(root);
        return count;
    }

    public boolean traverse(TreeNode root) {
        if (root == null) return true;
        boolean left = traverse(root.left);
        boolean right = traverse(root.right);
        if (left && right &&
                (root.left == null || root.val == root.left.val) &&
                (root.right == null || root.val == root.right.val)) {
            count++;
            return true;
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
