package Y2018.tree;

public class Q250_Count_Univalue_Subtrees_B {

    public int countUnivalSubtrees(TreeNode root) {
        int[] result = new int[1];
        isUnivalTree(result, root);
        return result[0];
    }

    private boolean isUnivalTree(int[] result, TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean l = isUnivalTree(result, root.left);
        boolean r = isUnivalTree(result, root.right);
        if ((root.left == null || root.val == root.left.val && l)
                && (root.right == null || root.val == root.right.val && r)) {
            result[0] += 1;
            return true;
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
