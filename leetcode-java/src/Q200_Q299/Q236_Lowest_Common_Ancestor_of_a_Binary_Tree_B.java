package Q200_Q299;

import java.util.*;

public class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree_B {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        boolean pp = false, qq = false;
        map.put(root, null);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == p) pp = true;
            if (cur == q) qq = true;
            if (pp && qq) break;
            if (cur.left != null) {
                map.put(cur.left, cur);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, cur);
                queue.add(cur.right);
            }
        }

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

}
