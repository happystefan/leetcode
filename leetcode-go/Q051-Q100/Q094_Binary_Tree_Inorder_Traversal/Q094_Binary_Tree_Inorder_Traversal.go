package Q094_Binary_Tree_Inorder_Traversal

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	ans := []int{}
	dfs(&ans, root)
	return ans
}

func dfs(ans *[]int, root *TreeNode) {
	if root == nil {
		return
	}
	dfs(ans, root.Left)
	*ans = append(*ans, root.Val)
	dfs(ans, root.Right)
}
