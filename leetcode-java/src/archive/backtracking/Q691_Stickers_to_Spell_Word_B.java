package archive.backtracking;

import java.util.*;

public class Q691_Stickers_to_Spell_Word_B {

    public int minStickers(String[] stickers, String target) {
        int n = target.length(), m = 1<<n; // if target has n chars, there will be m=2^n subset of characters in target
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (String sticker : stickers) {
                int sup = i;
                // for each char in the sticker, try apply it on a missing char in the subset of target
                for (char c : sticker.toCharArray()) {
                    for (int r = 0; r < n; r++) {
                        if (target.charAt(r) == c && ((sup >> r) & 1) == 0) {
                            sup |= 1 << r;
                            break;
                        }
                    }
                }
                // after you apply all possible chars in a sticker, you get an superset that take 1 extra sticker than subset
                // would take, so you can try to update the superset's min sticker number with archive.dp[sub]+1;
                dp[sup] = Math.min(dp[sup], dp[i] + 1);
            }
        }
        return dp[m-1] != Integer.MAX_VALUE ? dp[m-1] : -1;
    }

}
