package Q001

func twoSum(nums []int, target int) []int {
	m := map[int]int{}
	for i := 0; i < len(nums); i++ {
		if _, exist := m[target-nums[i]]; exist {
			return []int{i, m[target-nums[i]]}
		}
		m[nums[i]] = i
	}
	return []int{}
}
