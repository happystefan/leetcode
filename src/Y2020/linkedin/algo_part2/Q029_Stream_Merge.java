package Y2020.linkedin.algo_part2;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Q029_Stream_Merge {

    interface SortedIterator<E extends Comparable<E>> extends Iterator<E> {
        E next();

        boolean hasNext();
    }

    <E extends Comparable<E>> SortedIterator<E> merge(List<SortedIterator<E>> its) {
        PriorityQueue<Node> Q = new PriorityQueue<Node>((a, b) -> ((E) a.val).compareTo((E) b.val));
        for (SortedIterator<E> it : its) {
            if (!it.hasNext()) continue;
            Q.add(new Node(it.next(), it));
        }
        return new SortedIterator<E>() {
            @Override
            public E next() {
                if (!hasNext()) return null;
                Node smallest = Q.poll();
                if (smallest.it.hasNext()) {
                    Q.add(new Node(smallest.it.next(), smallest.it));
                }
                return (E) smallest.val;
            }

            @Override
            public boolean hasNext() {
                return !Q.isEmpty();
            }
        };
    }

    class Node<E extends Comparable<E>> {
        E val;
        SortedIterator<E> it;

        public Node(E val, SortedIterator<E> it) {
            this.val = val;
            this.it = it;
        }
    }

}
