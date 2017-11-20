package Q100_Q199;

import java.util.Arrays;

public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[nums.length/2]);
        if (nums.length == 1) return root;
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
        root.right =  sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2+1, nums.length));
        return root;
    }
}
