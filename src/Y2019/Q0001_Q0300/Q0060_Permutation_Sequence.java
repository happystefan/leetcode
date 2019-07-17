package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.List;

public class Q0060_Permutation_Sequence {

    public String getPermutation(int n, int k) {
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i;
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) nums.add(i);
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i <= n; i++) {
            int idx = k / fac[n - i];
            sb.append(nums.get(idx));
            nums.remove(idx);
            k %= fac[n - i];
        }
        return sb.toString();
    }

}
