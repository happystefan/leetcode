package Y2020.facebook.misc;

public class Q0270_Closest_Binary_Search_Tree_Value {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int closestValue(TreeNode root, double target) {
        int rslt = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(rslt - target)) rslt = root.val;
            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return rslt;
    }

}
