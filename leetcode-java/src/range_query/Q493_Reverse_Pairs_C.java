package range_query;

import java.util.Arrays;

public class Q493_Reverse_Pairs_C {

    // Make the BinarySearchTree Balance!
    public int reversePairs(int[] nums) {
        long[] sorted = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = 2*nums[i];
        }
        Arrays.sort(sorted);
        TreeNode root = build(sorted, 0, sorted.length-1);
        int result = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            result += search(root, nums[i]);
            root = insert(root, 2l*nums[i]);
        }
        return result;
    }

    private TreeNode build(long[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int m = l + (r-l)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = build(nums, l, m);
        root.right = build(nums, m+1, r);
        return root;
    }

    private int search(TreeNode root, long num) {
        if (root == null) {
            return 0;
        } else if(root.val == num) {
            return root.lsize;
        } else if (num < root.val) {
            return search(root.left, num);
        } else {
            return root.lsize + root.cnt + search(root.right, num);
        }
    }

    private TreeNode insert(TreeNode root, long num) {
        if (root.val == num) {
            root.cnt++;
        } else if (num < root.val) {
            root.lsize++;
            root.left = insert(root.left, num);
        } else if (num > root.val) {
            root.right = insert(root.right, num);
        }
        return root;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int cnt;
        long val;
        int lsize; // size of left sub tree
        public TreeNode(long val) {
            this.val = val;
        }
    }

}
