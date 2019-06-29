package Y2018.facebook.sliding_window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q632_Smallest_Range {

    public int[] smallestRange(List<List<Integer>> nums) {
        List<Pair> list = new ArrayList<>();
        for (int group = 0; group < nums.size(); group++) {
            for (int num : nums.get(group)) {
                list.add(new Pair(num, group));
            }
        }
        Collections.sort(list, (a, b) -> a.num - b.num);
        int[] result = new int[]{0, list.size()};
        int[] counts = new int[nums.size()]; // index is group, value is how many elements of group inside of the window
        int l = 0, r = 0; // left/right pointers if sliding window. right is not inclusive
        int groups = 0; // how many groups in current window
        while (r < list.size()) {
            Pair pair = list.get(r++);
            counts[pair.group]++;
            if (counts[pair.group] == 1) groups++;

            while (groups >= nums.size()) {
                if (list.get(result[1] - 1).num - list.get(result[0]).num > list.get(r - 1).num - list.get(l).num) {
                    result = new int[]{l, r};
                }
                pair = list.get(l++);
                counts[pair.group]--;
                if (counts[pair.group] == 0) groups--;
            }
        }
        return new int[]{list.get(result[0]).num, list.get(result[1] - 1).num};
    }

    class Pair {
        int num;
        int group;

        public Pair(int num, int group) {
            this.num = num;
            this.group = group;
        }
    }

}
