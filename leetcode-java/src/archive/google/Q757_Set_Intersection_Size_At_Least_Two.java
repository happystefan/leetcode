package archive.google;

import java.util.*;

public class Q757_Set_Intersection_Size_At_Least_Two {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0]-a[0] : a[1]-b[1]);
        int result = 0, largest = -1, second = -1;
        for (int[] interval : intervals) {
            boolean containsLargest = interval[0] <= largest;
            boolean containsSecond = interval[0] <= second;
            if (containsLargest && containsSecond) continue;
            result += containsLargest ? 1 : 2;
            second = containsLargest ? largest : interval[1]-1;
            largest = interval[1];
        }
        return result;
    }

}
