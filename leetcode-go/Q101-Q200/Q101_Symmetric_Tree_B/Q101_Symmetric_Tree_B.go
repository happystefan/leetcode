package Q101_Symmetric_Tree_B

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	stack := []*TreeNode{}
	stack = append(stack, root.Left)
	stack = append(stack, root.Right)

	for len(stack) >= 2 {
		l := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		r := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		if l == nil && r == nil {
			continue
		}
		if l == nil && r != nil || r == nil && l != nil {
			return false
		}

		if l.Val != r.Val {
			return false
		}
		stack = append(stack, l.Left)
		stack = append(stack, r.Right)
		stack = append(stack, l.Right)
		stack = append(stack, r.Left)
	}
	return len(stack) == 0
}
