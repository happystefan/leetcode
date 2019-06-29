package Y2018.facebook.tree;

public class Q129_Sum_Root_to_Leaf_Numbers {

    public int sumNumbers(TreeNode root) {
        int[] result = new int[]{0};
        dfs(result, root, 0);
        return result[0];
    }

    private void dfs(int[] result, TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result[0] += sum;
        }
        dfs(result, root.left, sum);
        dfs(result, root.right, sum);
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
