package leetcode_go

import "math"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	sum := len(nums1)+len(nums2)
	if sum%2 ==1 {
		return findkth(nums1, nums2, 0, 0, sum/2+1)
	} else {
		return (findkth(nums1, nums2, 0, 0, sum/2)+findkth(nums1, nums2, 0, 0, sum/2+1))/2
	}
	return 0
}

func findkth(nums1, nums2 []int, sz1, sz2, k int) float64 {
	if sz1 >= len(nums1) {
		return float64(nums2[sz2+k-1])
	}
	if sz2 >= len(nums2) {
		return float64(nums1[sz1+k-1])
	}
	if k == 1 {
		return min(nums1[sz1], nums2[sz2])
	}

	a, b := math.MaxInt32, math.MaxInt32
	if sz1+k/2-1 < len(nums1) {
		a = nums1[sz1+k/2-1]
	}
	if sz2+k/2-1 < len(nums2) {
		b = nums2[sz2+k/2-1]
	}

	if a < b {
		return findkth(nums1, nums2, sz1+k/2, sz2, k-k/2)
	} else {
		return findkth(nums1, nums2, sz1, sz2+k/2, k-k/2)
	}
	return 0
}

func min(a, b int) float64 {
	if a < b {
		return float64(a)
	}
	return float64(b)
}
