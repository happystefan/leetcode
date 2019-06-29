package Y2018.divide_and_conquer;

import java.util.Arrays;

public class Q493_Reverse_Pairs_B {

    TreeNode buildTree(long nums[], int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }

    public int reversePairs(int[] nums) {
        long[] dnums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dnums[i] = nums[i] * 2l;
        }
        Arrays.sort(dnums);
        TreeNode root = buildTree(dnums, 0, dnums.length - 1);
        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            result += root.count(nums[i]);
            root.add(2l * nums[i]);
        }
        return result;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        long val;
        int cnt;

        TreeNode(long val) {
            this.val = val;
        }

        void add(long n) {
            if (n <= val) cnt++;
            if (n < val) left.add(n);
            if (n > val) right.add(n);
        }

        int count(long n) {
            return n > val ? cnt + (right == null ? 0 : right.count(n))
                    : (left == null ? 0 : left.count(n));
        }
    }

}
