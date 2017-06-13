package Q061_Rotate_List

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil || k == 0 {
		return head
	}

	len := 1
	tail := head
	for tail.Next != nil {
		tail = tail.Next
		len++
	}

	// form a circle
	tail.Next = head

	for i := 0; i < len-k%len; i++ {
		tail = tail.Next
	}
	head = tail.Next
	tail.Next = nil
	return head
}
