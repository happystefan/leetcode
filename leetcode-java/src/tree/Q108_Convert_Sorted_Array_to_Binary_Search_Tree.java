package tree;

public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length-1);
    }

    private TreeNode toBST(int[] nums, int l, int r) {
        if (nums == null || nums.length == 0 || r < l) {
            return null;
        }
        int m = (l+r)/2;
        TreeNode root = new TreeNode(nums[m]);
        if (l == r) {
            return root;
        }
        root.left = toBST(nums, l, m-1);
        root.right= toBST(nums, m+1, r);
        return root;
    }

}
