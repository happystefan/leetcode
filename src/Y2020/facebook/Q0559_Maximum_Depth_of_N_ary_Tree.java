package Y2020.facebook;

import java.util.List;

public class Q0559_Maximum_Depth_of_N_ary_Tree {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        int[] rslt = new int[]{0};
        dfs(rslt, root, 0);
        return rslt[0];
    }

    private void dfs(int[] rslt, Node root, int depth) {
        if (root == null) return;
        rslt[0] = Math.max(rslt[0], depth + 1);
        if (root.children != null) {
            for (Node child : root.children) dfs(rslt, child, depth + 1);
        }
    }

}
