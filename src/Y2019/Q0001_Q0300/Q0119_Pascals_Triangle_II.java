package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.List;

public class Q0119_Pascals_Triangle_II {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (rowIndex-- > 0) {
            List<Integer> next = new ArrayList<>(result.size() + 1);
            next.add(1);
            for (int i = 1; i < result.size(); i++) {
                next.add(result.get(i - 1) + result.get(i));
            }
            next.add(1);
            result = next;
        }
        return result;
    }

}
