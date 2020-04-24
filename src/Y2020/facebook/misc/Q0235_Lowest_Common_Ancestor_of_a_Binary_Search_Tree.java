package Y2020.facebook.misc;

public class Q0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class solution_recursive {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            return root;
        }

    }

    class solution_iterative {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
            while (root.val < min || root.val > max) {
                if (root.val < min) root = root.right;
                if (root.val > max) root = root.left;
            }
            return root;
        }

    }

}
