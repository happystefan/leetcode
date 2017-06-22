package Q068_Text_Justification

func fullJustify(words []string, maxWidth int) []string {
	ans := []string{}
	begin := 0
	for begin < len(words) {
		last := begin
		count := len(words[last])
		last++
		for last < len(words) && count+len(words[last])+1 <= maxWidth {
			count += len(words[last]) + 1
			last++
		}

		space, extra := 1, 0
		if last < len(words) && last != begin+1 {
			space = (maxWidth-count)/(last-begin-1) + 1
			extra = (maxWidth - count) % (last - begin - 1)
		}

		line := []byte(words[begin])
		begin++

		for ; extra > 0; extra-- {
			line = appendnspace(line, space+1)
			line = append(line, words[begin]...)
			begin++
		}
		for begin < last {
			line = appendnspace(line, space)
			line = append(line, words[begin]...)
			begin++
		}
		line = appendnspace(line, maxWidth-len(line))

		ans = append(ans, string(line))
	}
	return ans
}

func appendnspace(s []byte, n int) []byte {
	for ; n > 0; n-- {
		s = append(s, ' ')
	}
	return s
}
