package archive.Q001_Q300;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_Binary_Tree_Right_Side_View {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                if (!queue.isEmpty() && queue.peek() == null) ans.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            } else {
                if (!queue.isEmpty())queue.add(null);
            }
        }
        return ans;
    }

}
