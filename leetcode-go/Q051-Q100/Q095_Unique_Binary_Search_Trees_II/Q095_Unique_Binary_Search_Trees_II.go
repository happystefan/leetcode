package Q095_Unique_Binary_Search_Trees_II

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func generateTrees(n int) []*TreeNode {
	if n < 1 {
		return []*TreeNode{}
	}
	return dfs(1, n)
}

func dfs(b, e int) []*TreeNode {
	trees := []*TreeNode{}
	if b > e {
		return append(trees, nil)
	}
	if b == e {
		return append(trees, &TreeNode{Val: b})
	}
	for i := b; i <= e; i++ {
		ltrees := dfs(b, i-1)
		rtrees := dfs(i+1, e)

		for _, ltree := range ltrees {
			for _, rtree := range rtrees {
				root := &TreeNode{Val: i}
				root.Left = ltree
				root.Right = rtree
				trees = append(trees, root)
			}
		}
	}
	return trees
}
