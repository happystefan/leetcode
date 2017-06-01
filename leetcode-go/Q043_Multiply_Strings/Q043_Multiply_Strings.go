package Q043_Multiply_Strings

func multiply(num1 string, num2 string) string {
	res := make([]int, len(num1)+len(num2))
	for i := len(num1) - 1; i >= 0; i-- {
		for j := len(num2) - 1; j >= 0; j-- {
			mul := int(num1[i]-'0') * int(num2[j]-'0')
			p1, p2 := i+j, i+j+1
			res[p1] += (res[p2] + mul) / 10
			res[p2] = (res[p2] + mul) % 10
		}
	}

	h := -1
	for i := 0; i < len(res); i++ {
		if res[i] != 0 {
			break
		}
		h = i
	}

	ans := []byte("")
	for i := h + 1; i < len(res); i++ {
		ans = append(ans, byte('0'+res[i]))
	}
	if len(ans) == 0 {
		ans = append(ans, '0')
	}
	return string(ans)
}
