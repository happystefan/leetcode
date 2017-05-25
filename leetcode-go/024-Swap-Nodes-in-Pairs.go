package leetcode_go

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
	res := &ListNode{}
	res.Next = head

	p := res

	for head != nil && head.Next != nil {
		first := head
		second := head.Next

		first.Next = second.Next
		second.Next = first

		head = first.Next

		p.Next = second
		p = first
	}

	return res.Next
}

// solution 2: recursive
func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	second := head.Next
	third := second.Next

	second.Next = head
	head.Next = swapPairs(third)

	return second
}
