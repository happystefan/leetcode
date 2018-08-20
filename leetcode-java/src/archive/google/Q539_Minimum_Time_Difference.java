package archive.google;

import java.util.*;

public class Q539_Minimum_Time_Difference {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            result = Integer.min(result, diff(timePoints.get(i-1), timePoints.get(i)));
        }
        result = Integer.min(result, diff(timePoints.get(timePoints.size()-1), timePoints.get(0))+1440);
        return result;
    }

    private int diff(String a, String b) {
        int h1 = Integer.valueOf(a.substring(0, 2));
        int h2 = Integer.valueOf(b.substring(0, 2));
        int m1 = Integer.valueOf(a.substring(3));
        int m2 = Integer.valueOf(b.substring(3));
        return h2*60+m2-(h1*60+m1);
    }

}
