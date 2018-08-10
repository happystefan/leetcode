package facebook;

import java.util.*;

public class Q406_Queue_Reconstruction_by_Height {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        List<int[]> list = new ArrayList<>(people.length);
        for (int[] p : people) {
            list.add(p[1], p);
        }
        int[][] result = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
