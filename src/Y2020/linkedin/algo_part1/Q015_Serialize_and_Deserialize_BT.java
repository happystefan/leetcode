package Y2020.linkedin.algo_part1;

import java.util.Scanner;

public class Q015_Serialize_and_Deserialize_BT {

    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        return deserialize(new Scanner(data));
    }

    private TreeNode deserialize(Scanner sc) {
        if (!sc.hasNext()) return null;
        String token = sc.next();
        if (token.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = deserialize(sc);
        root.right = deserialize(sc);
        return root;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

}

