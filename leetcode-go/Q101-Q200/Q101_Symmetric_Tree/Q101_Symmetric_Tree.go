package Q101_Symmetric_Tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	return root == nil || isSym(root.Left, root.Right)
}

func isSym(l, r *TreeNode) bool {
	if l == nil || r == nil {
		return l == r
	}
	return l.Val == r.Val && isSym(l.Left, r.Right) && isSym(l.Right, r.Left)
}
