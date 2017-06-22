package Q092_Reverse_Linked_List_II

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	dummy := &ListNode{}
	dummy.Next = head

	lp := dummy
	for i := 0; i < m-1; i++ {
		lp = lp.Next
	}

	start := lp.Next
	end := start
	for i := 0; i < n-m; i++ {
		tail := end.Next.Next
		lp.Next = end.Next
		lp.Next.Next = start
		end.Next = tail
		start = lp.Next
	}

	return dummy.Next
}
