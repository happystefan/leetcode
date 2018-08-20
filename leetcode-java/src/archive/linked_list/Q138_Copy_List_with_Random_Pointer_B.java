package archive.linked_list;

public class Q138_Copy_List_with_Random_Pointer_B {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode next = curr.next;
            curr.next = new RandomListNode(curr.label);
            curr.next.next = next;
            curr = next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        RandomListNode result = new RandomListNode(0);
        curr = result;
        while (head != null) {
            curr.next = head.next;
            curr = curr.next;
            head.next = head.next.next;
            head = head.next;
        }
        return result.next;
    }

}
