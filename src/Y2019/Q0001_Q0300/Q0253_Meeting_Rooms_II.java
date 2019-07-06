package Y2019.Q0001_Q0300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q0253_Meeting_Rooms_II {

    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int result = 0;
        int sum = 0;
        for (int[] pair : list) {
            sum += pair[1];
            result = Math.max(result, sum);
        }
        return result;
    }

}
