package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q016_Find_Palindromes {

    // TC: 2^N
    public Set<String> findPalindromes(String str) {
        Map<String, Set<String>> map = new HashMap<>();
        return findPalindromes(str, map);
    }

    private Set<String> findPalindromes(String str, Map<String, Set<String>> map) {
        if (map.containsKey(str)) return map.get(str);
        Set<String> rslt = new HashSet<>();
        int n = str.length();
        if (n < 1) return rslt;
        if (n == 1) {
            rslt.add(str);
            return rslt;
        }
        rslt.addAll(findPalindromes(str.substring(n - 1), map));
        rslt.addAll(findPalindromes(str.substring(1, n), map));
        if (str.charAt(0) == str.charAt(n - 1)) {
            char c = str.charAt(0);
            Set<String> set = findPalindromes(str.substring(1, n - 1), map);
            for (String p : set) {
                rslt.add(c + p + c);
            }
            rslt.add("" + c + c);
        }
        return rslt;
    }

    public int numOfPalindromesAllowDuplicate(String str) {
        char[] ss = str.toCharArray();
        int n = ss.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l - 1;
                if (ss[i] == ss[j]) {
                    // dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + - dp[i + 1][j - 1] + - dp[i - 1][j - 1] + 1;
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    // remove common palindromic subsequences as they
                    // are counted twice
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][n - 1];
    }

    public int numOfPalindromesWithoutDuplicate(String str) {
        /*
        For a substring abcba, the extreme characters ('a') can contribute following ways:

        Step 1: If 'bcb' is pre computed to 3 ('b', 'c', 'bcb') then considering 'a's will make it
        6 ('b', 'c', 'bcb', 'aba', 'aca', 'abcba'). This has been taken care by the following code
        ```
            dp[beg][end] = 2 * dp[beg + 1][end - 1];
        ```
        Step 2: In addition it will also add 'a' and 'aa'. However we need to check if 'a' exists
        in the current substring. If there is no occurrence of 'a'
        ```
            if(leftIdx > rightIdx){
                  dp[beg][end] += 2;
            }
        ```
        Step 3: If there is one occurrence of 'a' then we will add just 1 to the count since 'aa'
        will be duplicated in that case.
        ```
            else if (leftIdx == rightIdx){
                dp[beg][end] += 1;
            }
        ```
        Step 4: Lastly, if there are two occurrences of 'a' then we need to remove the duplicate palindrome
        added in step 1. For example, 'aabaa' the substring 'aba' will have 'a', 'b', 'aba' palindromes.
        After step 1 we will have 'a', 'b', 'aba', 'aaa', 'aba', 'aabaa'. To remove the additional 'aba'
        this code has been added
        ```
            else{
                dp[beg][end] -= dp[leftIdx + 1][rightIdx - 1];
            }
        ```
        */
        char[] ss = str.toCharArray();
        int n = ss.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l - 1;
                if (ss[i] == ss[j]) {
                    int ii = i + 1;
                    int jj = j - 1;
                    while (ii <= jj && ss[ii] != ss[i]) {
                        ii++;
                    }
                    while (ii <= jj && ss[jj] != ss[i]) {
                        jj--;
                    }
                    if (ii > jj) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (ii == jj) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[ii + 1][jj - 1];
                    }

                } else {
                    // remove common palindromic subsequences as they
                    // are counted twice
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }
        return dp[0][n - 1];
    }

}
