package archive.range_query;

public class Q493_Reverse_Pairs_B {

    // Time Limit Exceeded: since archive.tree can be skewed in extreme situation.
    public int reversePairs(int[] nums) {
        TreeNode root = null;
        int result = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            result += search(root, nums[i]);
            root = insert(root, 2l*nums[i]);
        }
        return result;
    }

    private int search(TreeNode root, long num) {
        if (root == null) {
            return 0;
        } else if(root.val == num) {
            return root.size;
        } else if (num < root.val) {
            return search(root.left, num);
        } else {
            return root.size + root.cnt + search(root.right, num);
        }
    }

    private TreeNode insert(TreeNode root, long num) {
        if (root == null) {
            root = new TreeNode(num, 0);
        } else if (root.val == num) {
            root.cnt++;
        } else if (num < root.val) {
            root.size++;
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
        int size; // size of left sub archive.tree
        public TreeNode(long val, int size) {
            this.val = val;
            this.size = size;
            this.cnt = 1;
        }
    }

}
