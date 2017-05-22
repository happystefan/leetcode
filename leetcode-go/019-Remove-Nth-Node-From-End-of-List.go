package leetcode_go

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	h := &ListNode{Next:head}
	l, r := h, h
	for i:=0; i<n; i++ {
		r = r.Next
	}
	for r.Next != nil {
		r = r.Next
		l = l.Next
	}
	if l.Next != nil {
		l.Next = l.Next.Next
	}
	return h.Next
}