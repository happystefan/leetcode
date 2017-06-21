package Q083_Remove_Duplicates_from_Sorted_List

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	ptr := head
	for ptr != nil && ptr.Next != nil {
		if ptr.Next.Val == ptr.Val {
			ptr.Next = ptr.Next.Next
		} else {
			ptr = ptr.Next
		}
	}
	return head
}
