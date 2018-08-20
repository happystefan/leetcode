package archive.Q001_Q300;

import java.util.*;

public class Q248_Strobogrammatic_Number_III {

    public int strobogrammaticInRange(String low, String high) {
        List<String> list = new LinkedList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            list.addAll(findStrobogrammatic(i, true));
        }
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() == low.length() && s.compareTo(low) < 0 || s.length() == high.length() && s.compareTo(high) > 0) {
                continue;
            }
            ans++;
        }
        return ans;
    }

    public List<String> findStrobogrammatic(int n, boolean firstCall) {
        List<String> ans = new LinkedList<>();
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");
        List<String> sublist = findStrobogrammatic(n-2, false);
        for (String sub : sublist) {
            if (!firstCall) ans.add("0"+sub+"0");
            ans.add("1"+sub+"1");
            ans.add("8"+sub+'8');
            ans.add("6"+sub+"9");
            ans.add("9"+sub+"6");
        }
        return ans;
    }

}
