package Y2018.Q001_Q300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q236_Lowest_Common_Ancestor_of_a_Binary_Tree {

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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
