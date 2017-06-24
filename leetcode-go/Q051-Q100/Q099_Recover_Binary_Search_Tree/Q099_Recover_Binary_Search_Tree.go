package Q099_Recover_Binary_Search_Tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func recoverTree(root *TreeNode) {
	var lnode, rnode, pnode *TreeNode

	var traverse func(root *TreeNode)
	traverse = func(root *TreeNode) {
		if root == nil {
			return
		}
		traverse(root.Left)
		if pnode != nil && pnode.Val >= root.Val {
			if lnode == nil {
				lnode = pnode
			}
			rnode = root
		}
		pnode = root
		traverse(root.Right)
	}

	traverse(root)
	lnode.Val, rnode.Val = rnode.Val, lnode.Val
	return
}
