package Y2020.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q0987_Vertical_Order_Traversal_of_a_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> rslt = new LinkedList<>();
        if (root == null) return rslt;
        List<int[]> list = new ArrayList<>();
        dfs(list, root, 0, 0);
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        int[] prev = null;
        for (int[] pair : list) {
            if (prev == null || pair[0] != prev[0]) rslt.add(new LinkedList<>());
            rslt.get(rslt.size() - 1).add(pair[2]);
            prev = pair;
        }
        return rslt;
    }

    private void dfs(List<int[]> list, TreeNode root, int x, int y) {
        if (root == null) return;
        list.add(new int[]{x, y, root.val});
        dfs(list, root.left, x - 1, y + 1);
        dfs(list, root.right, x + 1, y + 1);
    }

}
