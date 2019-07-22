package Y2019.Q0001_Q0300;

import java.util.LinkedList;
import java.util.List;

public class Q0093_Restore_IP_Addresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        dfs(result, new LinkedList<>(), s, 0);
        return result;
    }

    private void dfs(List<String> result, List<String> list, String s, int pos) {
        if (list.size() == 4) {
            if (pos == s.length()) result.add(String.join(".", list));
            return;
        }
        for (int l = 1; l <= 3 && pos + l <= s.length(); l++) {
            String part = s.substring(pos, pos + l);
            int val = Integer.valueOf(part);
            if (part.equals(String.valueOf(val)) && val >= 0 && val <= 255) {
                list.add(part);
                dfs(result, list, s, pos + l);
                list.remove(list.size() - 1);
            }
        }
    }

}
