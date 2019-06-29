package Y2018.tree;

import java.util.ArrayList;

public class Q501_Find_Mode_in_Binary_Search_Tree {

    TreeNode prev = null;
    int max_cnt = 0;
    int cnt = 0;
    ArrayList<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] result = new int[modes.size()];
        int i = 0;
        for (int v : modes) {
            result[i++] = v;
        }
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null && prev.val == root.val) {
            cnt++;
        } else {
            cnt = 1;
        }
        if (cnt >= max_cnt) {
            if (cnt > max_cnt) {
                modes.clear();
            }
            modes.add(root.val);
            max_cnt = cnt;
        }
        prev = root;
        dfs(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
