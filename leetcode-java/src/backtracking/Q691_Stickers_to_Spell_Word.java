package backtracking;

import java.util.*;

public class Q691_Stickers_to_Spell_Word {

    Map<String, Integer> map = new HashMap<>();
    public int minStickers(String[] stickers, String target) {
        int[][] hists = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                hists[i][c-'a']++;
            }
        }
        return dfs(hists, target);
    }

    private int dfs(int[][] hists, String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (map.containsKey(str)) {
            return map.get(str);
        }
        int[] target = new int[26];
        for (char c : str.toCharArray()) {
            target[c-'a']++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < hists.length; i++) {
            // If the target can be spelled out by a group of stickers,
            // at least one of them has to contain character target[0].
            // So I explicitly require next sticker containing target[0],
            // which significantly reduced the search space.
            if (hists[i][str.charAt(0)-'a'] == 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (target[j] == 0) {
                    continue;
                }
                int cnt = Math.max(0, target[j]-hists[i][j]);
                while (cnt-- > 0) {
                    sb.append((char) ('a' + j));
                }
            }
            int tmp = dfs(hists, sb.toString());
            if (tmp != -1) {
                result = Math.min(result, tmp+1);
            }
        }
        map.put(str, result == Integer.MAX_VALUE ? -1 : result);
        return map.get(str);
    }

}
