package archive.bfs_dfs;

import java.util.*;

public class Q301_Remove_Invalid_Parentheses {

    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int l = 0, r = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') {
                l++;
            }
            if (ss[i] == ')') {
                if (l != 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        Set<String> set = new HashSet<>();
        set.add("");
        for (int i = 0; i < ss.length; i++) {
            Set<String> tmp = new HashSet<>(set);
            for (String str : tmp) {
                if (str.length() >= ss.length-l-r) {
                    continue;
                }
                set.add(str+ss[i]);
            }
        }
        List<String> result = new LinkedList<>();
        for (String str : set) {
            if (str.length() == ss.length-l-r && isValid(str)) {
                result.add(str);
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int sum = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') ++sum;
            else if(c == ')') --sum;
            if(sum < 0) return false;
        }
        return sum == 0;
    }

}
