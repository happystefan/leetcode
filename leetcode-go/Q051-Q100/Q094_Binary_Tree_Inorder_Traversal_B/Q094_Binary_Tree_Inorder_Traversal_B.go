package Q094_Binary_Tree_Inorder_Traversal_B

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	stack := []*TreeNode{}
	ans := []int{}
	for root != nil || len(stack) > 0 {
		for root != nil {
			stack = append(stack, root)
			root = root.Left
		}

		ans = append(ans, stack[len(stack)-1].Val)
		root = stack[len(stack)-1].Right
		stack = stack[:len(stack)-1]
	}
	return ans
}
