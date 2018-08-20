package archive.Q001_Q300;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q219_Contains_Duplicate_II {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new LinkedList<>());
            List<Integer> indice = map.get(nums[i]);
            indice.add(i);
            if (indice.size() >= 2 && indice.get(indice.size()-1)-indice.get(indice.size()-2) <= k) return true;
            map.put(nums[i], indice);
        }
        return false;
    }

}
