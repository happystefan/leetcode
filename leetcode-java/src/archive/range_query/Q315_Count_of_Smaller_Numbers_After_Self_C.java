package archive.range_query;

import java.util.Arrays;
import java.util.List;

public class Q315_Count_of_Smaller_Numbers_After_Self_C {

    // BinarySearchTree
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        TreeNode root = null;
        Integer[] result = new Integer[n];
        for (int i = n-1; i >= 0; i--) {
            root = insert(root, result, nums, i, 0);
        }
        return Arrays.asList(result);
    }

    private TreeNode insert(TreeNode root, Integer[] result, int[] nums, int i, int pre) {
        if (root == null) {
            root = new TreeNode(nums[i], 0);
            result[i] = pre;
        } else if (root.val == nums[i]) {
            root.cnt++;
            result[i] = root.size+pre;
        } else if (nums[i] < root.val) {
            root.size++;
            root.left = insert(root.left, result, nums, i, pre);
        } else if (nums[i] > root.val) {
            root.right = insert(root.right, result, nums, i, pre+root.size+root.cnt);
        }
        return root;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int cnt;
        int val;
        int size; // size of left sub archive.tree
        public TreeNode(int val, int size) {
            this.val = val;
            this.size = size;
            this.cnt = 1;
        }
    }

}
