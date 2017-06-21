package Q057_Insert_Interval

import "sort"

type Interval struct {
	Start int
	End   int
}

func insert(intervals []Interval, newInterval Interval) []Interval {
	return merge(append(intervals, newInterval))
}

func merge(intervals []Interval) []Interval {
	sort.Sort(itvs(intervals))
	ans := []Interval{}
	for i := 0; i < len(intervals); i++ {
		itv := intervals[i]
		for j := i + 1; j < len(intervals) && intervals[j].Start <= itv.End; j++ {
			itv.End = max(itv.End, intervals[j].End)
			i++
		}
		ans = append(ans, itv)
	}
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

type itvs []Interval

func (itv itvs) Less(i, j int) bool {
	if itv[i].Start == itv[j].Start {
		return itv[i].End < itv[j].End
	}
	return itv[i].Start < itv[j].Start
}

func (itv itvs) Len() int {
	return len(itv)
}

func (itv itvs) Swap(i, j int) {
	itv[i], itv[j] = itv[j], itv[i]
}
