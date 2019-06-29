package Q001_Q300;

public class Q129_Sum_Root_to_Leaf_Numbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumPath(root, 0);
    }

    public int sumPath(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        return sumPath(root.left, sum * 10 + root.val) + sumPath(root.right, sum * 10 + root.val);
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
