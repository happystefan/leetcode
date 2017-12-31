package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q406_Queue_Reconstruction_by_Height {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            return b[0] == a[0] ? a[1]-b[1] : b[0]-a[0];
        });
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) queue.add(p[1], p);
        int[][] ans = new int[people.length][2];
        for (int i = 0; i < people.length; i++) ans[i] = queue.get(i);
        return ans;
    }

}
