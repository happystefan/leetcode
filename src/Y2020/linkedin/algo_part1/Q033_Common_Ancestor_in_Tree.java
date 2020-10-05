package Y2020.linkedin.algo_part1;

import java.util.HashSet;
import java.util.Set;

public class Q033_Common_Ancestor_in_Tree {

    public TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root.val == a.val || root.val == b.val) {
            return root;
        }
        TreeNode l = lca(root.left, a, b);
        TreeNode r = lca(root.right, a, b);
        if (l != null && r != null) {
            return root;
        } else {
            return l != null ? l : r;
        }
    }

    public TreeNode lca_path(TreeNode a, TreeNode b) {
        if (a == b) return a;
        if (a == null || b == null)  return null;
        Set<TreeNode> set = new HashSet<>();
        while (a != null) {
            set.add(a);
            a = a.parent;
        }
        while (b != null) {
            if (set.contains(b)) return b;
            b = b.parent;
        }
        return null;
    }


    public TreeNode lca_depth(TreeNode a, TreeNode b) {
        if (a == b) return a;
        if (a == null || b == null)  return null;

        int depthA = depth(a);
        int depthB = depth(b);
        TreeNode deeper = depthA > depthB ? a : b;
        TreeNode shallower = depthA > depthB ? b : a;
        int diff = Math.abs(depthA - depthB);
        while (diff-- > 0) {
            deeper = deeper.parent;
        }
        while (deeper != shallower) {
            deeper = deeper.parent;
            shallower = shallower.parent;
        }
        return deeper;
    }

    private int depth(TreeNode root) {
        int rslt = 0;
        while (root != null) {
            rslt += 1;
            root = root.parent;
        }
        return rslt;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }

        public boolean isRoot() {
            return this.parent == null;
        }
    }

}

