package tree;

public class Q654_Maximum_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length-1);
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int max = nums[l], idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(nums, l, idx-1);
        root.right= construct(nums, idx+1, r);
        return root;
    }

}
