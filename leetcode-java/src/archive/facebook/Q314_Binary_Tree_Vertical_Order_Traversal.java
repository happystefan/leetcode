package archive.facebook;

import java.util.*;

public class Q314_Binary_Tree_Vertical_Order_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> lpart = new LinkedList<>();
        List<Integer> mpart = new LinkedList<>();
        List<List<Integer>> rpart = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> QN = new LinkedList<>();
        Queue<Integer> QO = new LinkedList<>();
        QN.offer(root);
        QO.offer(0);
        while (!QN.isEmpty()) {
            int size = QN.size();
            while (size-- > 0) {
                TreeNode curr = QN.poll();
                int offset = QO.poll();
                if (offset == 0) {
                    mpart.add(curr.val);
                } else if (offset < 0) {
                    if (lpart.size() < -offset) {
                        lpart.add(0, new LinkedList<>());
                    }
                    lpart.get(lpart.size()+offset).add(curr.val);
                } else if (offset > 0) {
                    if (rpart.size() < offset) {
                        rpart.add(new LinkedList<>());
                    }
                    rpart.get(offset-1).add(curr.val);
                }
                if (curr.left != null) {
                    QN.offer(curr.left);
                    QO.offer(offset-1);
                }
                if (curr.right != null) {
                    QN.offer(curr.right);
                    QO.offer(offset+1);
                }
            }
        }
        result.addAll(lpart);
        result.add(mpart);
        result.addAll(rpart);
        return result;
    }

}
