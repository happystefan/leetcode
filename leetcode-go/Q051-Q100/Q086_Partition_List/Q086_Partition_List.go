package Q086_Partition_List

type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	dummy := &ListNode{}
	dummy.Next = head

	gp, g := dummy, head
	for g != nil {
		for g != nil && g.Val < x {
			if g.Next == nil {
				return dummy.Next
			}
			g = g.Next
			gp = gp.Next
		}

		lp, l := gp, g
		for l != nil && l.Val >= x {
			if l.Next == nil {
				return dummy.Next
			}

			l = l.Next
			lp = lp.Next
		}

		lp.Next = l.Next
		gp.Next = l
		l.Next = g

		g = l
	}
	return dummy.Next
}
