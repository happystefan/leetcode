import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q107_Binary_Tree_Level_Order_Traversal_II_B {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                levelList.add(queue.poll().val);
            }
            ans.add(0, levelList);
        }
        return ans;
    }
}
