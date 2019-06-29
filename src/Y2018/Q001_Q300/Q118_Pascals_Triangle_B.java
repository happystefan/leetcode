package Y2018.Q001_Q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q118_Pascals_Triangle_B {

    // NOTE: Any row can be constructed using the offset sum of the previous row. Example:
    //     1 3 3 1 0
    //  +  0 1 3 3 1
    //  =  1 4 6 4 1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (ans.size() == 0) {
                ans.add(Arrays.asList(1));
            } else {
                List<Integer> pre = new ArrayList<>(ans.get(ans.size() - 1));
                List<Integer> nxt = new ArrayList<>(pre);
                pre.add(0, 0);
                nxt.add(0);
                for (int j = 0; j < nxt.size(); j++) nxt.set(j, nxt.get(j) + pre.get(j));
                ans.add(nxt);
            }
        }
        return ans;
    }

}
