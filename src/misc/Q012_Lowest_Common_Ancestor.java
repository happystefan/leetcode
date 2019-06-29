package misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q012_Lowest_Common_Ancestor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
    * */
    class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Map<TreeNode, TreeNode> map = new HashMap<>();
            travese(root, null, map);
            Set<TreeNode> set = new HashSet<>();
            while (p != null) {
                set.add(p);
                p = map.get(p);
            }
            while (q != null) {
                if (set.contains(q)) return q;
                q = map.get(q);
            }
            return null;
        }

        public void travese(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
            map.put(root, parent);
            if (root.left != null) travese(root.left, root, map);
            if (root.right != null) travese(root.right, root, map);
        }
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
    * */
    class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree_B {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            if (l != null && r != null) {
                return root;
            } else if (l != null) {
                return l;
            } else if (r != null) {
                return r;
            } else {
                return null;
            }
        }
    }

    class Q235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            return root;
        }
    }

}
