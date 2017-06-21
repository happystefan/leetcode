package Q067_Add_Binary

func addBinary(a string, b string) string {
	ans := []byte{}
	aa, bb := len(a)-1, len(b)-1
	carry := 0
	for aa >= 0 || bb >= 0 {
		sum := carry
		if aa >= 0 {
			sum += int(a[aa] - '0')
			aa--
		}
		if bb >= 0 {
			sum += int(b[bb] - '0')
			bb--
		}
		ans = append([]byte{byte('0' + sum%2)}, ans...)
		carry = sum / 2
	}
	if carry != 0 {
		ans = append([]byte{'1'}, ans...)
	}
	return string(ans)
}
