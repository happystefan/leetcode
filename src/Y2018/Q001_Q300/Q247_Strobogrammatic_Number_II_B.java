package Y2018.Q001_Q300;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q247_Strobogrammatic_Number_II_B {

    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, true);
    }

    public List<String> findStrobogrammatic(int n, boolean firstCall) {
        List<String> ans = new LinkedList<>();
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");
        List<String> sublist = findStrobogrammatic(n - 2, false);
        for (String sub : sublist) {
            if (!firstCall) ans.add("0" + sub + "0");
            ans.add("1" + sub + "1");
            ans.add("8" + sub + '8');
            ans.add("6" + sub + "9");
            ans.add("9" + sub + "6");
        }
        return ans;
    }

}
