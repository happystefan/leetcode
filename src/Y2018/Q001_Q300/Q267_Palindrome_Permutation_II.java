package Y2018.Q001_Q300;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q267_Palindrome_Permutation_II {

    public List<String> generatePalindromes(String s) {
        int[] map = new int[256];
        for (Character c : s.toCharArray()) {
            map[c]++;
        }
        List<String> ans = new LinkedList<>();
        int once = -1, exist = 0;
        for (int i = 0; i < 256; i++) {
            if (exist == 0 && map[i] % 2 == 1) {
                exist++;
                once = i;
            } else if (map[i] % 2 == 1) {
                return ans;
            }
        }
        String cur = "";
        if (once != -1) {
            cur += (char) once;
            map[once]--;
        }
        dfs(ans, cur, map, s.length());
        return ans;
    }

    public void dfs(List<String> ans, String cur, int[] map, int len) {
        if (cur.length() == len) {
            ans.add(cur);
            return;
        }

        for (int i = 0; i < 256; i++) {
            if (map[i] == 0) continue;
            map[i] -= 2;
            dfs(ans, (char) i + cur + (char) i, map, len);
            map[i] += 2;
        }
    }

}
