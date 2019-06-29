package facebook;

import java.util.TreeSet;

public class Q683_K_Empty_Slots {

    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            Integer higher = set.higher(flowers[i]);
            Integer lower = set.lower(flowers[i]);
            if (higher != null && higher - flowers[i] - 1 == k) {
                return i + 1;
            }
            if (lower != null && flowers[i] - lower - 1 == k) {
                return i + 1;
            }
            set.add(flowers[i]);
        }
        return -1;
    }

}
