package google;

import java.util.SortedSet;
import java.util.TreeSet;

public class Q683_K_Empty_Slots {

    public int kEmptySlots(int[] flowers, int k) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            SortedSet<Integer> head = set.headSet(flowers[i]);
            SortedSet<Integer> tail = set.tailSet(flowers[i]);
            if (!head.isEmpty() && flowers[i]-head.last() == k) return i+1;
            if (!tail.isEmpty() && tail.first()-flowers[i] == k) return i+1;
            set.add(flowers[i]);
        }
        return -1;
    }

}

