package leetcode_go

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	merge := &ListNode{}
	res := merge
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			merge.Next = &ListNode{Val:l1.Val}
			l1 = l1.Next
		} else if l1.Val > l2.Val {
			merge.Next = &ListNode{Val:l2.Val}
			l2 = l2.Next
		}
		merge = merge.Next
	}
	if l1 != nil {
		merge.Next = l1
	}
	if l2 != nil {
		merge.Next = l2
	}

	return res.Next
}
