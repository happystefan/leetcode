package Y2020.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q1110_Delete_Nodes_And_Return_Forest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> rslt = new LinkedList<>();
        if (root == null) {
            rslt.add(root);
            return rslt;
        }
        Set<Integer> set = new HashSet<>();
        for (int d : to_delete) set.add(d);
        dfs(root, rslt, set, true);
        return rslt;
    }

    private TreeNode dfs(TreeNode root, List<TreeNode> rslt, Set<Integer> set, boolean isRoot) {
        if (root == null) return null;
        boolean delete = set.contains(root.val);
        if (isRoot && !delete) rslt.add(root);
        root.left = dfs(root.left, rslt, set, delete);
        root.right = dfs(root.right, rslt, set, delete);
        return delete ? null : root;
    }

}
