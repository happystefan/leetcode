package Y2019.misc;

import java.util.LinkedList;
import java.util.List;

public class Q0002_Reorder_Tree {

    public TreeNode reorderTree(TreeNode root, List<int[]> rules) {
        if (root == null) return null;

        List<List<int[]>> allPaths = new LinkedList<>();
        if (root.left != null) dfs(allPaths, root, new LinkedList<>(), 0);
        if (root.right != null) dfs(allPaths, root, new LinkedList<>(), 1);

        for (int[] rule : rules) {
            for (List<int[]> path : allPaths) {
                int[] tmp = path.get(rule[0]);
                path.set(rule[0], path.get(rule[1]));
                path.set(rule[1], tmp);
            }
        }

        TreeNode dummyRoot = new TreeNode(0);
        for (List<int[]> path : allPaths) {
            dummyRoot.left = rebuildTree(path, 0);
        }
        return dummyRoot.left;
    }

    private TreeNode rebuildTree(List<int[]> path, int level) {
        if (level == path.size()) return null;
        int[] pair = path.get(level);
        int val = pair[0], dir = pair[1];
        TreeNode root = new TreeNode(val);
        if (dir == 0) root.left = rebuildTree(path, level + 1);
        if (dir == 1) root.right = rebuildTree(path, level + 1);
        return root;
    }

    private void dfs(List<List<int[]>> allPaths, TreeNode root, List<int[]> path, int dir) {
        path.add(new int[]{root.val, dir});
        if (root.left == null && root.right == null) {
            allPaths.add(path);
            return;
        }
        if (root.left != null) dfs(allPaths, root.left, new LinkedList<>(path), 0);
        if (root.right != null) dfs(allPaths, root.right, new LinkedList<>(path), 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
