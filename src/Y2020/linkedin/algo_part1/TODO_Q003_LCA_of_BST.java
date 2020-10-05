package Y2020.linkedin.algo_part1;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TODO_Q003_LCA_of_BST {

    class solution_recursive {

        public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (p.val < root.val && q.val < root.val) return LCA(root.left, p, q);
            else if (p.val > root.val && q.val > root.val) return LCA(root.right, p, q);
            return root;
        }

    }

    class solution_iterative {
        public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
            while (root != null) {
                if (p.val < root.val && q.val < root.val) root = root.left;
                else if (p.val > root.val && q.val > root.val) root = root.right;
                else break;
            }
            return root;
        }
    }

    class LCA_of_BT {

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


    class LCA_of_BT_B {

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
            } else return r;
        }
    }





    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
