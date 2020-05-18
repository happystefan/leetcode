package Y2020.facebook.misc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0199_Binary_Tree_Right_Side_View {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class solution_bfs {

        public List<Integer> rightSideView(TreeNode root) {
            Queue<TreeNode> Q = new LinkedList<>();
            if (root != null) Q.add(root);
            List<Integer> rslt = new LinkedList<>();
            while (!Q.isEmpty()) {
                int size = Q.size();
                while (size-- > 0) {
                    TreeNode curr = Q.poll();
                    if (curr.left != null) Q.add(curr.left);
                    if (curr.right != null) Q.add(curr.right);
                    if (size == 0) rslt.add(curr.val);
                }
            }
            return rslt;
        }

    }

    class solution_dfs {

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> rslt = new LinkedList<>();
            dfs(rslt, root, 0);
            return rslt;
        }

        private void dfs(List<Integer> rslt, TreeNode root, int level) {
            if (root == null) return;
            if (rslt.size() == level) rslt.add(root.val);
            dfs(rslt, root.left, level + 1);
            dfs(rslt, root.right, level + 1);
        }

    }

}
