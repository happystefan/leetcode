package Q001_Q300;

import java.util.HashSet;
import java.util.Set;

public class Q217_Contains_Duplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

}
