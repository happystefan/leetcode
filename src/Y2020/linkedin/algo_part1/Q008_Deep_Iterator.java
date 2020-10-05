package Y2020.linkedin.algo_part1;

import java.util.*;

public class Q008_Deep_Iterator {

    public class DeepIterator<T> implements Iterator<T> {

        private Stack<Iterator<Data<T>>> stack = new Stack<>();
        private Iterator<Data<T>> lastIt  = null; // only used when implement remove()
        private T data;
        private boolean populated;

        public DeepIterator(Collection<Data<T>> c) {
            if (c != null) {
                stack.push(c.iterator());
            }
        }

        @Override
        public boolean hasNext() {
            while (!populated) {
                if (stack.isEmpty()) return false;
                Iterator<Data<T>> it = stack.peek();
                if (!it.hasNext()) {
                    stack.pop();
                } else {
                    Data<T> nxt = it.next();
                    if (nxt.isCollection()) {
                        stack.push((Iterator<Data<T>>) nxt.getCollection().iterator());
                    } else {
                        data = nxt.getElement();
                        populated = true;
                    }
                }
            }
            return true;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastIt = stack.peek();
            populated = false;
            return data;
        }

        public void remove() {
            if (lastIt == null) throw new IllegalStateException("next() has never been called");
            lastIt.remove();
        }
    }


    public class DeepIteratorRec<T> implements Iterator<T> {

        private Iterator<Data<T>> currIt = null;
        private Iterator<T> nextIt = null;
        private T data;
        private boolean populated;

        public DeepIteratorRec(Collection<Data<T>> c) {
            if (c != null) {
                currIt = c.iterator();
            }
        }


        @Override
        public boolean hasNext() {
            while (!populated) {
                if (nextIt != null && nextIt.hasNext()) return true;
                else if (currIt == null || !currIt.hasNext()) {
                    break;
                } else {
                    Data<T> nxt = currIt.next();
                    if (nxt.isCollection()) {
                        nextIt = new DeepIteratorRec(nxt.getCollection());
                    } else {
                        data = nxt.getElement();
                        populated = true;
                    }
                }
            }
            return populated;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            else if (populated) {
                nextIt = null; // only need when implement remove()
                populated = false;
                return data;
            } else {
                return nextIt.next();
            }
        }
    }


    interface Data<T> {
        boolean isCollection();
        Collection<T> getCollection();
        T getElement();
    }

}
