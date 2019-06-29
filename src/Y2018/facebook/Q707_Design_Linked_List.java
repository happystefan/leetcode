package Y2018.facebook;

public class Q707_Design_Linked_List {

    class MyLinkedList {

        // head and tail are actually dummy nodes
        ListNode head;
        ListNode tail;
        int len = 0;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= len) {
                return -1;
            }
            ListNode curr = head.next;
            while (index-- > 0) {
                curr = curr.next;
            }
            return curr.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            ListNode next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            len++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            ListNode prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
            len++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > len) {
                return;
            }
            if (index == len) {
                addAtTail(val);
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            ListNode prev = head;
            while (index-- > 0) {
                prev = prev.next;
            }
            ListNode next = prev.next;
            ListNode node = new ListNode(val);
            prev.next = node;
            node.prev = prev;
            node.next = next;
            next.prev = node;
            len++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= len) {
                return;
            }
            ListNode prev = head;
            while (index-- > 0) {
                prev = prev.next;
            }
            ListNode next = prev.next.next;
            prev.next = next;
            next.prev = prev;
            len--;
        }
    }

    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

}
