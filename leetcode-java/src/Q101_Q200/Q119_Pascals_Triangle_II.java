package Q101_Q200;

import java.util.ArrayList;
import java.util.List;

public class Q119_Pascals_Triangle_II {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; i++) {
            ans.add(1);
            for (int j = i-1; j > 0; j--) {
                ans.set(j, ans.get(j)+ans.get(j-1));
            }
        }
        return ans;
    }

}
