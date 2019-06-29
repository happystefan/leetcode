package range_query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q632_Smallest_Range_B {

    public static int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int num : nums.get(i)) {
                list.add(new int[]{num, i});
            }
        }
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[]{0, list.size()};
        int[] counts = new int[nums.size()]; // index is group, value is how many values of group inside of the window
        int groups = 0; // number of groups inside of the sliding window
        int l = 0, r = 0; // window left/right pointers. right is not inclusive
        while (l < list.size()) {
            if (groups < nums.size() && r < list.size()) { // not all groups in the window
                int[] ng = list.get(r);
                counts[ng[1]]++;
                if (counts[ng[1]] == 1) groups++;
                r++;
            } else { // all groups in the window
                int[] ng = list.get(l);
                counts[ng[1]]--;
                if (counts[ng[1]] == 0) groups--;
                l++;
            }
            // if all the groups in the window check if window is smaller then current result
            if (groups == nums.size()) {
                if (list.get(result[1] - 1)[0] - list.get(result[0])[0] > list.get(r - 1)[0] - list.get(l)[0]) {
                    result[0] = l;
                    result[1] = r;
                }
            }
        }
        return new int[]{list.get(result[0])[0], list.get(result[1] - 1)[0]};
    }

}
