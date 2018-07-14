package range_query;

import java.util.Arrays;

public class Q327_Count_of_Range_Sum_C {

    // Make the BinarySearchTree Balance!
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i]+nums[i];
        }

        long[] sorted = Arrays.copyOf(sums, sums.length);
        Arrays.sort(sorted);
        TreeNode root = build(sorted, 0, sorted.length-1);

        int result = 0;
        for (long sum : sums) {
            result += search(root, sum-lower, true) - search(root, sum-upper, false);
            root = insert(root, sum);
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
        int m = l+(r-l)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = build(nums, l, m);
        root.right= build(nums, m+1, r);
        return root;
    }

    // number of nodes < target if inclusive = false
    // number of nodes <= target if inclusive = true
    private int search(TreeNode root, long target, boolean inclusive) {
        if (root == null) {
            return 0;
        } else if (root.val == target) {
            return inclusive ? root.cnt + root.lsize : root.lsize;
        } else if (target < root.val) {
            return search(root.left, target, inclusive);
        } else {
            return root.cnt + root.lsize + search(root.right, target, inclusive);
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
        long val;
        int cnt;
        int lsize; // size of it's left subtree
        public TreeNode(long val) {
            this.val = val;
        }
    }

}
