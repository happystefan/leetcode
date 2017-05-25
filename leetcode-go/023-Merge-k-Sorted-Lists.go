package leetcode_go

import "math"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
	heads := make([]*ListNode, len(lists))
	for i := 0; i < len(lists); i++ {
		heads[i] = &ListNode{}
		heads[i].Next = lists[i]
	}

	merge := &ListNode{}
	res := merge

	isDone := func() bool {
		for j := 0; j < len(heads); j++ {
			if heads[j].Next != nil {
				return false
			}
		}
		return true
	}

	for !isDone() {
		min := math.MaxInt32
		idx := -1
		for i := 0; i < len(heads); i++ {
			if heads[i].Next != nil && heads[i].Next.Val < min {
				min = heads[i].Next.Val
				idx = i
			}
		}
		merge.Next = &ListNode{}
		merge.Next.Val = min
		merge = merge.Next
		heads[idx] = heads[idx].Next
	}

	return res.Next
}
