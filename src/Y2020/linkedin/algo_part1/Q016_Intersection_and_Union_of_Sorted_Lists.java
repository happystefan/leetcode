package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q016_Intersection_and_Union_of_Sorted_Lists {

    List<Integer> union(List<Integer> lista, List<Integer> listb) {
        if (lista == null || lista.size() == 0) return new LinkedList<>(listb);
        if (listb == null || listb.size() == 0) return new LinkedList<>(lista);
        List<Integer> rslt = new LinkedList<>();
        Iterator<Integer> ita = lista.iterator();
        Iterator<Integer> itb = listb.iterator();
        Integer a = ita.hasNext() ? ita.next() : null;
        Integer b = itb.hasNext() ? itb.next() : null;
        while (a != null || b != null) {
            if (a == null) {
                rslt.add(b);
                b = itb.hasNext() ? itb.next() : null;
            } else if (b == null) {
                rslt.add(a);
                a = ita.hasNext() ? ita.next() : null;
            } else if (a < b) {
                rslt.add(a);
                a = ita.hasNext() ? ita.next() : null;
            } else {
                rslt.add(b);
                b = itb.hasNext() ? itb.next() : null;
            }
        }
        return rslt;

        // Follow up: merge K list, N is total number of ele in ALL lists
        // * merge one by one: N*K
        // * using heap: O(N*logK)
    }

    List<Integer> intersect(List<Integer> lista, List<Integer> listb) {
        if (lista == null || lista.size() == 0) return new LinkedList<>();
        if (listb == null || listb.size() == 0) return new LinkedList<>();
        List<Integer> rslt = new LinkedList<>();
        Iterator<Integer> ita = lista.iterator();
        Iterator<Integer> itb = listb.iterator();
        Integer a = ita.hasNext() ? ita.next() : null;
        Integer b = itb.hasNext() ? itb.next() : null;
        while (a != null && b != null) {
            if (a < b) {
                a = ita.hasNext() ? ita.next() : null;
            } else if (b < a) {
                b = itb.hasNext() ? itb.next() : null;
            } else {
                rslt.add(a);
                a = ita.hasNext() ? ita.next() : null;
                b = itb.hasNext() ? itb.next() : null;
            }
        }
        return rslt;
    }
}
