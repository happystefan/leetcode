package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q0118_Pascals_Triangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if (numRows == 0) return result;
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = result.get(result.size() - 1);
            List<Integer> next = new ArrayList<>(list.size() + 1);
            next.add(1);
            for (int j = 1; j < list.size(); j++) {
                next.add(list.get(j - 1) + list.get(j));
            }
            next.add(1);
            result.add(next);
        }
        return result;
    }

}
