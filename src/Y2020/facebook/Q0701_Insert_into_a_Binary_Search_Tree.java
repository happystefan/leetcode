package Y2020.facebook;

public class Q0701_Insert_into_a_Binary_Search_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class solution_iterative {

        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode node = root;
            while (node != null) {
                if (node.val < val) {
                    if (node.right == null) {
                        node.right = new TreeNode(val);
                        return root;
                    } else {
                        node = node.right;
                    }
                } else {
                    if (node.left == null) {
                        node.left = new TreeNode(val);
                        return root;
                    } else {
                        node = node.left;
                    }
                }
            }
            return new TreeNode(val);
        }

    }

    class soltion_recursive {

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (root.val < val) root.right = insertIntoBST(root.right, val);
            else root.left = insertIntoBST(root.left, val);
            return root;
        }

    }

}
