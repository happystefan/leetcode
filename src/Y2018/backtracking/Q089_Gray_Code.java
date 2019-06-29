package Y2018.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q089_Gray_Code {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        result.add(0);
        for (int i = 0; i < n; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) | 1 << i);
            }
        }
        return result;
    }

}
