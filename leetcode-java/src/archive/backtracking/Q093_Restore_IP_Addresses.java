package archive.backtracking;

import java.util.*;

public class Q093_Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), s, 0);
        return result;
    }

    private void dfs(List<String> result, List<String> list, String s, int pos) {
        if (list.size() > 4) {
            return;
        }
        if (pos == s.length() && list.size() == 4) {
            result.add(String.join(".", list));
            return;
        }
        for (int i = pos+1; i <= s.length(); i++) {
            String sub = s.substring(pos, i);
            int num = Integer.valueOf(sub);
            if (num > 255) {
                break;
            }
            if (!sub.equals(String.valueOf(num))) {
                continue;
            }
            if (0 <= num && num <= 255) {
                list.add(sub);
                dfs(result, list, s, i);
                list.remove(list.size()-1);
            }
        }
    }

}
