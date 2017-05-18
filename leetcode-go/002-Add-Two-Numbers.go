package leetcode_go

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{Val:0}
	next := head
	carry := 0

	for l1 != nil || l2 != nil || carry != 0 {
		if l1 != nil {
			next.Val += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			next.Val += l2.Val
			l2 = l2.Next
		}
		next.Val += carry

		carry = next.Val/10
		next.Val %= 10

		if !(l1==nil && l2==nil && carry==0) {
			next.Next = &ListNode{Val:0}
			next = next.Next
		}
	}
	return head
}
