package Q089_Gray_Code

func grayCode(n int) []int {
	ans := make([]int, 1<<uint32(n))
	for i := 0; i < 1<<uint32(n); i++ {
		ans[i] = i ^ (i >> 1)
	}
	return ans
}
