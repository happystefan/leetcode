package Q086_Partition_List_B

type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	dummy1, dummy2 := &ListNode{}, &ListNode{}
	cur1, cur2 := dummy1, dummy2

	for head != nil {
		if head.Val < x {
			cur1.Next = head
			cur1 = cur1.Next
		} else {
			cur2.Next = head
			cur2 = cur2.Next
		}
		head = head.Next
	}

	cur2.Next = nil
	cur1.Next = dummy2.Next
	return dummy1.Next
}
