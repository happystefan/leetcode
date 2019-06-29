package Y2018.Q001_Q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q117_Populating_Next_Right_Pointers_in_Each_Node_II {

    public void connect(TreeLinkNode root) {
        if (root == null) return;

        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int num = queue.size();

            for (int i = 0; i < num; i++) {
                TreeLinkNode cur = queue.poll();

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);

                if (i == num - 1) cur.next = null;
                else cur.next = queue.peek();
            }
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
