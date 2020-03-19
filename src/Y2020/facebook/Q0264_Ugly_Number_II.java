package Y2020.facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0264_Ugly_Number_II {

    public int nthUglyNumber(int n) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1));
        int i = 0, j = 0, k = 0;
        while (list.size() < n) {
            int ii = list.get(i) * 2;
            int jj = list.get(j) * 3;
            int kk = list.get(k) * 5;
            int nn = Math.min(Math.min(ii, jj), kk);
            if (nn == ii) i++;
            if (nn == jj) j++;
            if (nn == kk) k++;
            list.add(nn);
        }
        return list.get(n - 1);
    }

}
