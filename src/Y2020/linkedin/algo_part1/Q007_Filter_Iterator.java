package Y2020.linkedin.algo_part1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Q007_Filter_Iterator {

    public abstract class FilterIterator<T> implements Iterator<T> {
        protected Predicate<T> selector;
        protected Iterator<T> source;

        protected FilterIterator(Predicate<T> selector, Iterator<T> source) {
            this.selector = selector;
            this.source = source;
        }

        public abstract boolean hasNext();
        public abstract T next();
    }

    public interface Predicate<T> {
        boolean apply(T sample);
    }

    class FilterIteratorImpl<T> extends FilterIterator<T> {

        private T data;
        private boolean populated;

        protected FilterIteratorImpl(Predicate<T> selector, Iterator<T> source) {
            super(selector, source);
        }

        @Override
        public boolean hasNext() {
            while (!populated && source.hasNext()) {
                data = source.next();
                populated = selector.apply(data);
            }
            return populated;
        }

        @Override
        public T next() {
            if (!populated) throw new NoSuchElementException();
            populated = false;
            return data;
        }

        // remove() can NOT been implemented, because calling hasNext() modifies the underlying iterator state
        // a call to next(), followed by a hasNext(), followed by remove() will remove the next element to be
        // returned, not the current one.
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
