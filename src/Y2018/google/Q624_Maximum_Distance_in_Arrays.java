package Y2018.google;

import java.util.List;

public class Q624_Maximum_Distance_in_Arrays {

    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> array = arrays.get(0);
        int min = array.get(0), max = array.get(array.size() - 1);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            array = arrays.get(i);
            result = Math.max(result, Math.max(Math.abs(array.get(0) - max), Math.abs(array.get(array.size() - 1) - min)));
            min = Math.min(min, array.get(0));
            max = Math.max(max, array.get(array.size() - 1));
        }
        return result;
    }

}
