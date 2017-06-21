package Q025_Reverse_Nodes_in_k_Group

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	cur := head
	for i := 0; i < k; i++ {
		if cur == nil {
			return head
		}
		cur = cur.Next
	}

	ans := reverse(head, cur)
	head.Next = reverseKGroup(cur, k)
	return ans
}

func reverse(first, last *ListNode) *ListNode {
	res := last
	for first != last {
		tmp := first.Next

		first.Next = res
		res = first

		first = tmp

	}
	return res
}
