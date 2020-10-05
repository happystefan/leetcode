package Y2020.linkedin.algo_part2;

import java.util.*;

public class Q030_Largest_K_Integers {

    // TreeSet -- without duplication
    class TopSet<V extends Comparable<V>> {
        private int maxSize;
        private TreeSet<V> set = new TreeSet<>();
        public TopSet(int maxSize) {
            this.maxSize = maxSize;
        }

        public void add(V nextVal)  {
            if (maxSize <= 0) return;
            // This if statement is a performance improvement, it's not necessary
            // for correctness
            if (set.size() >= maxSize && nextVal.compareTo(set.first()) <= 0) {
                return;
            }
            set.add(nextVal);
            if (set.size() > maxSize) set.pollFirst();
        }

        public Collection<V> getTop() {
            return Collections.unmodifiableSet(set);
        }
    }

    // PriorityQueue -- with duplication
    class TopList<V extends Comparable<V>> {
        private int maxSize;
        private PriorityQueue<V> Q = new PriorityQueue<>();
        public TopList(int maxSize) {
            this.maxSize = maxSize;
        }

        public void add(V nextVal)  {
            if (maxSize <= 0) return;
            // This if statement is a performance improvement, it's not necessary
            // for correctness
            if (Q.size() >= maxSize && nextVal.compareTo(Q.peek()) <= 0) {
                return;
            }
            Q.add(nextVal);
            if (Q.size() > maxSize) Q.poll();
        }
        public Collection<V> getTop() {
            return List.copyOf(Q);
        }
    }

}
