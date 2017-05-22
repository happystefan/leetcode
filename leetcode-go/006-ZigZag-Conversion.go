package leetcode_go

func convert(s string, numRows int) string {
	ss := []byte(s)
	// NOTE: take care of the initialization here
	res := make([][]byte, numRows)
	for i := 0; i < numRows; i++ {
		res[i] = []byte{}
	}

	idx := 0
	for idx < len(ss) {
		for i := 0; i < numRows && idx < len(ss); i++ { // vertically down
			res[i] = append(res[i], ss[idx])
			idx++
		}
		for i := numRows - 2; i >= 1 && idx < len(ss); i-- { //obliquely up
			res[i] = append(res[i], ss[idx])
			idx++
		}
	}

	for i := 1; i < numRows; i++ {
		res[0] = append(res[0], res[i]...)
	}

	return string(res[0])
}
