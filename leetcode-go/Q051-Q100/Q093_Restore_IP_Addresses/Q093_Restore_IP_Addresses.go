package Q093_Restore_IP_Addresses

import (
	"strconv"
	"strings"
)

func restoreIpAddresses(s string) []string {
	ips := [][]string{}
	dfs(&ips, []string{}, s, 0, 0)
	ans := []string{}
	for _, ip := range ips {
		ans = append(ans, strings.Join(ip, "."))
	}
	return ans
}

func dfs(ans *[][]string, ip []string, s string, idx, cnt int) {
	if cnt == 4 && idx == len(s) {
		*ans = append(*ans, ip)
		return
	}
	if cnt > 4 {
		return
	}
	for i := 1; i < 4; i++ {
		if idx+i > len(s) {
			break
		}
		ss := s[idx : idx+i]
		n, _ := strconv.Atoi(ss)
		if (ss[0] == '0' && len(ss) > 1) || n > 255 {
			continue
		}
		nip := make([]string, len(ip))
		copy(nip, ip)
		nip = append(nip, ss)
		dfs(ans, nip, s, idx+i, cnt+1)
	}
}
