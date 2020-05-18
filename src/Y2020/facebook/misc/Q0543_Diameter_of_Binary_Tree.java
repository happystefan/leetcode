package Y2020.facebook.misc;

public class Q0543_Diameter_of_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] rslt = new int[]{1};
        depth(rslt, root);
        return rslt[0] - 1;
    }

    private int depth(int[] rslt, TreeNode root) {
        if (root == null) return 0;
        int l = depth(rslt, root.left);
        int r = depth(rslt, root.right);
        rslt[0] = Math.max(rslt[0], l + r + 1);
        return Math.max(l, r) + 1;
    }

}
