package range_query;

public class Q327_Count_of_Range_Sum_B {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        TreeNode root = null;
        int result = 0;
        for (long sum : sums) {
            result += search(root, sum - lower, true) - search(root, sum - upper, false);
            root = insert(root, sum);
        }
        return result;
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
        if (root == null) {
            root = new TreeNode(num);
        } else if (root.val == num) {
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
            this.cnt = 1;
        }
    }

}
