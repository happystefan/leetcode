package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q655_Print_Binary_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int w = (int)Math.pow(2, h)-1;
        List<List<String>> result = new LinkedList<>();
        for (int l = 1; l <= h; l++) {
            String[] levelArray = new String[w];
            Arrays.fill(levelArray, "");
            dfs(levelArray, root, l, 0, w);
            result.add(Arrays.asList(levelArray));
        }
        return result;
    }

    private void dfs(String[] levelArray, TreeNode root, int level, int start, int end) {
        if (root == null) {
            return;
        }
        int m = (start+end)/2;
        if (level == 1) {
            levelArray[m] = String.valueOf(root.val);
            return;
        }
        dfs(levelArray, root.left, level-1, start, m-1);
        dfs(levelArray, root.right,level-1, m+1, end);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
