package facebook.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q095_Unique_Binary_Search_Trees_II {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new LinkedList<>();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) nums[i] = i;
        return genTree(nums, 1, n);
    }

    private List<TreeNode> genTree(int[] nums, int l, int r) {
        List<TreeNode> result = new LinkedList<>();
        if (l > r) {
            result.add(null);
            return result;
        }
        if (l == r) {
            result.add(new TreeNode(nums[l]));
            return result;
        }
        for (int i = l; i <= r; i++) {
            List<TreeNode> lpart = genTree(nums, l, i - 1);
            List<TreeNode> rpart = genTree(nums, i + 1, r);
            for (TreeNode ll : lpart) {
                for (TreeNode rr : rpart) {
                    TreeNode root = new TreeNode(i);
                    root.left = ll;
                    root.right = rr;
                    result.add(root);
                }
            }
        }
        return result;
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
