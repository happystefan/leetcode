package Q075_Sort_Colors

func sortColors(nums []int) {
	var n0, n1, n2 int
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			nums[n2] = 2
			n2++
			nums[n1] = 1
			n1++
			nums[n0] = 0
			n0++
		} else if nums[i] == 1 {
			nums[n2] = 2
			n2++
			nums[n1] = 1
			n1++
		} else if nums[i] == 2 {
			nums[n2] = 2
			n2++
		}
	}
}
