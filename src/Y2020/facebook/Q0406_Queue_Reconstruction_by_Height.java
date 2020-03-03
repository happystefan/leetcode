package Y2020.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0406_Queue_Reconstruction_by_Height {

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return new int[][]{};
        int n = people.length;
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> queue = new ArrayList<>(n);
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        int[][] rslt = new int[n][2];
        int i = 0;
        for (int[] p : queue) rslt[i++] = p;
        return rslt;
    }

}
