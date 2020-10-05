package Y2020.linkedin.algo_part2;

public class Q019_Flatten {

    class Node {
        Node left;
        Node right;
        Node parent;
        Node child;
    }

    class List {
        Node head;
        Node tail;
    }


    public void flatten(List list) {
        Node curr = list.head;
        while (curr != null) {
            if (curr.parent != null) {
                Node l = leftMost(curr.parent);
                Node r = rightMost(curr.parent);
                append(list, l, r);
                curr.parent.child = null;
            }
            if (curr.child != null) {
                Node l = leftMost(curr.child);
                Node r = rightMost(curr.child);
                append(list, l, r);
                curr.child.parent = null;
            }
            curr.parent = null;
            curr.child = null;
            curr = curr.right;
        }
    }

    private Node leftMost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node rightMost(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private void append(List list, Node leftMost, Node rightMost) {
        list.tail.right = leftMost;
        leftMost.left = list.tail;;
        list.tail = rightMost;
    }
}

