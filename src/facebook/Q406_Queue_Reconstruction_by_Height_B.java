package facebook;

import java.util.Arrays;

public class Q406_Queue_Reconstruction_by_Height_B {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        TreeNode root = null;
        for (int i = 0; i < people.length; i++) {
            root = insert(root, people[i], people[i][1]);
        }
        int[][] result = new int[people.length][2];
        dfs(root, result, new int[1]);
        return result;
    }

    private void dfs(TreeNode node, int[][] result, int[] i) {
        if (node == null) return;
        dfs(node.left, result, i);
        result[i[0]] = node.val;
        i[0]++;
        dfs(node.right, result, i);
    }

    private TreeNode insert(TreeNode root, int[] val, int pos) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (pos <= root.lsize) {
            root.lsize++;
            root.left = insert(root.left, val, pos);
        } else {
            root.right = insert(root.right, val, pos - root.lsize - 1);
        }
        return root;
    }

    class TreeNode {
        int[] val;
        int lsize;
        TreeNode left, right;

        public TreeNode(int[] v) {
            val = v;
            lsize = 0;
        }
    }

}
