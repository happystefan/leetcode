package google;

/**
 * Created by mingqiangliang on 12/23/17.
 */
public class Q689_Two_Sum_BST_edtion {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int[] twoSum(TreeNode root, int n) {
        if (root == null || root.left == null && root.right == null) return null;
        TreeNode l = getMin(root), r = getMax(root);
        while (l.val < r.val) {
            int sum = l.val+r.val;
            if (sum < n) l = getNext(root, l);
            else if (sum > n) r = getPre(root, r);
            else break;
        }
        return new int[]{l.val, r.val};
    }

    private TreeNode getPre(TreeNode root, TreeNode n) {
        if (n.left != null) return getMax(n.left);

        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > n.val) {
                cur = cur.left;
            } else if (cur.val < n.val) {
                pre = cur;
                cur = cur.right;
            } else {
                break;
            }
        }
        return pre;
    }

    private TreeNode getNext(TreeNode root, TreeNode n) {
        if (n.right != null) return getMin(n.right);

        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > n.val) {
                pre = cur;
                cur = cur.left;
            } else if (cur.val < n.val) {
                cur = cur.right;
            } else {
                break;
            }
        }
        return pre;
    }

    private TreeNode getMin(TreeNode root) {
        TreeNode p = root;
        while (p.left != null) p = p.left;
        return p;
    }

    private TreeNode getMax(TreeNode root) {
        TreeNode p = root;
        while (p.right != null) p = p.right;
        return p;
    }

}
