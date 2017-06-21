package Q005

/*
// solution 1: dp
func longestPalindrome(s string) string {
	// NOTE: take care of the initialization here
	dp := make([][]bool, len(s))
	for i := range dp {
		dp[i] = make([]bool, len(s))
	}
	var sz, l, r int
	for i := 0; i < len(s); i++ {
		for j := 0; j < i; j++ {
			dp[j][i] = s[i] == s[j] && (i-j < 2 || dp[j+1][i-1])
			if dp[j][i] && i-j+1 > sz {
				sz = i - j + 1
				l, r = j, i
			}
		}
		dp[i][i] = true
	}
	return s[l : r+1]
}

// solution 2: brute force with pruning
/*
Key idea, every time we move to right, we only need to consider whether using this
new character as tail could produce new palindrome string of length (current length +1)
or (current length +2)

Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now we
          are dealing with the last character 'a'. The current longest palindrome
          is "bcb" with length 3.
1. check "xxxxa" so if it is palindrome we could get a new palindrome of length 5.
2. check "xxxa" so if it is palindrome we could get a new palindrome of length 4.
3. do NOT check "xxa" or any shorter string since the length of the new string is
   no bigger than current longest length.
4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome
   then "xxxx" got from cutting off the head and tail is also palindrome. It has
   length > 3 which is impossible.'
*/
/*
func longestPalindrome(s string) string {
	res := ""
	lenz := 0
	for i := 0; i < len(s); i++ {
		if isPalindrome(s, i-lenz-1, i) {
			res = s[i-lenz-1 : i+1]
			lenz += 2
		}
		if isPalindrome(s, i-lenz, i) {
			res = s[i-lenz : i+1]
			lenz += 1
		}
	}
	return res
}

func isPalindrome(s string, l, r int) bool {
	if l < 0 {
		return false
	}
	for l < r {
		if s[l] != s[r] {
			return false
		}
		l++
		r--
	}
	return true
}
*/

// solution 4: two pointer
// TODO: runtime error
var lenz, idx int

func longestPalindrome(s string) string {
	if len(s) < 2 {
		return s
	}
	for i := 0; i < len(s)-1; i++ {
		extend(s, i, i)
		extend(s, i, i+1)
	}
	return s[idx : idx+lenz]
}

func extend(s string, l, r int) {
	for l >= 0 && r < len(s) && s[l] == s[r] {
		l--
		r++
	}
	if r-l-1 > lenz {
		lenz = r - l - 1
		idx = l + 1
	}
}

// TODO: solution 3: Manacher's Algorithm
