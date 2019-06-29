package Y2018.microsoft;

public class Q270_Closest_Binary_Search_Tree_Value {

    public int closestValue(TreeNode root, double target) {
        int l = root.val, r = root.val;
        while (root != null) {
            if (root.val < target) {
                l = root.val;
                root = root.right;
            } else if (root.val > target) {
                r = root.val;
                root = root.left;
            } else {
                return root.val;
            }
        }
        return Math.abs(l - target) > Math.abs(r - target) ? r : l;
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
