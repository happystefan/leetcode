package Y2020.linkedin.algo_part1;

import javax.management.InvalidAttributeValueException;
import java.io.*;
import java.util.Scanner;

public class Q016_Serialize_and_Deserialize_BST {

    public void serialize(TreeNode root, String fileName) throws IOException {
        FileOutputStream w = new FileOutputStream(fileName);
        try {
            serialize(root, w);
        } catch (Exception e) {
            // clear w
        } finally {
            w.flush();
            w.close();
        }
    }

    private void serialize(TreeNode root, FileOutputStream w) throws IOException, InvalidAttributeValueException {
        if (root == null) {
            w.write("#".getBytes());
            return;
        }
        if (root.left != null && root.left.val >= root.val ||
                root.right != null && root.right.val <= root.val) {
            throw new InvalidAttributeValueException();
        }
        w.write(root.val);
        w.write(" ".getBytes());
        serialize(root.left, w);
        w.write(" ".getBytes());
        serialize(root.right, w);
    }

    public TreeNode deserialize(String fileName) throws FileNotFoundException, InvalidAttributeValueException {
        Scanner scanner = new Scanner(new File(fileName));
        return deserialize(scanner, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private TreeNode deserialize(Scanner scanner, long lowerBound, long upperBound) throws InvalidAttributeValueException {
        if (!scanner.hasNext()) return null;
        String token = scanner.next();
        if (token.equals("#")) return null;
        int val = Integer.valueOf(token);
        if (val <= lowerBound || val >= upperBound) {
            throw new InvalidAttributeValueException();
        }
        TreeNode node = new TreeNode(val);
        node.left = deserialize(scanner, lowerBound, val);
        node.right = deserialize(scanner, val, upperBound);
        return node;
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
