package Y2018.google;

import java.util.Arrays;
import java.util.List;

public class Q315_Count_of_Smaller_Numbers_After_Self_B {

    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], 0, i, ans);
        }
        return Arrays.asList(ans);
    }

    private TreeNode insert(TreeNode root, int num, int pre, int i, Integer[] ans) {
        if (root == null) {
            root = new TreeNode(num, 0);
            ans[i] = pre;
        } else if (root.val == num) {
            root.dup++;
            ans[i] = pre + root.sum;
        } else if (root.val > num) {
            root.sum++;
            root.left = insert(root.left, num, pre, i, ans);
        } else if (root.val < num) {
            root.right = insert(root.right, num, pre + root.dup + root.sum, i, ans);
        }
        return root;
    }

    class TreeNode {
        int val, sum, dup = 1;
        TreeNode left, right;

        public TreeNode(int val, int sum) {
            this.val = val;
            this.sum = sum;
        }
    }

}
