package archive.misc;

import java.util.*;

public class Q019_Morris_Traversal {

    /*
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node2.left = node1;
        node2.right = node4;

        node4.left = node3;
        node4.right = node5;

        node6.left = node2;
        node6.right = node7;

        node7.right = node9;
        node9.left = node8;

        Solution solution = new Solution();
        List<Integer> result = solution.inOrder(node6);
        System.out.println(result);

        result = solution.preOrder(node6);
        System.out.println(result);

        result = solution.postOrder(node6);
        System.out.println(result);
    }
    */

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root;
        TreeNode prev;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) prev = prev.right;
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    result.add(curr.val);
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root;
        TreeNode prev;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) prev = prev.right;
                if (prev.right == null) {
                    result.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        TreeNode curr = dummy;
        TreeNode prev;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr) prev = prev.right;
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    add(result, curr.left, prev);
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    private void add(List<Integer> result, TreeNode from, TreeNode to) {
        reverse(from, to);
        TreeNode curr = to;
        while (true){
            result.add(curr.val);
            if (curr == from) break;
            curr = curr.right;
        }
        reverse(to, from);
    }

    private void reverse(TreeNode from, TreeNode to) {
        if (from == to) return;
        TreeNode head = from, next = from.right;
        while (true) {
            TreeNode tmp = next.right;
            next.right = head;
            head = next;
            next = tmp;
            if (head == to) break;
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) { this.val = val; }
    }

}
