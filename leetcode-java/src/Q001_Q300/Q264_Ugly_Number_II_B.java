package Q001_Q300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q264_Ugly_Number_II_B {

    public int nthUglyNumber(int n) {
        List<Integer> table = new ArrayList<>();
        table.add(1);
        int i = 0, j = 0, k = 0;
        while (table.size() < n) {
            int nxt = Math.min(table.get(i)*2, Math.min(table.get(j)*3, table.get(k)*5));
            table.add(nxt);
            if (table.get(i)*2 == nxt) i++;
            if (table.get(j)*3 == nxt) j++;
            if (table.get(k)*5 == nxt) k++;
        }
        return table.get(n-1);
    }

}
