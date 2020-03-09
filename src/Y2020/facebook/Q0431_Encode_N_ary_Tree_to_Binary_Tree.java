package Y2020.facebook;

import java.util.LinkedList;
import java.util.List;

public class Q0431_Encode_N_ary_Tree_to_Binary_Tree {

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

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Codec {

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) return null;
            TreeNode rslt = new TreeNode(root.val);
            if (root.children != null && root.children.size() != 0) {
                rslt.left = encode(root.children.get(0));
            }
            TreeNode sibling = rslt.left;
            if (root.children != null && root.children.size() != 0) {
                for (int i = 1; i < root.children.size(); i++) {
                    sibling.right = encode(root.children.get(i));
                    sibling = sibling.right;
                }
            }
            return rslt;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) return null;
            Node rslt = new Node(root.val, new LinkedList<>());
            TreeNode sibling = root.left;
            while (sibling != null) {
                rslt.children.add(decode(sibling));
                sibling = sibling.right;
            }
            return rslt;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));

}
