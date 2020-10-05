package Y2020.linkedin.concurrency;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q006_Block_Queue {


    interface BoundBlockQueue {
         Object get() throws Exception;

         void put(Object obj) throws Exception;
    }

    interface MultiPutBoundBlockQueue extends BoundBlockQueue {
         void multiput(List<Object> objs) throws Exception;
    }

    class MultiPutBlockQueue implements MultiPutBoundBlockQueue {

        private Queue<Object> Q = new LinkedList<>();
        private int capacity;
        private Lock lock = new ReentrantLock();
        private Lock multiPutLock = new ReentrantLock();
        private Condition isEmpty = lock.newCondition();
        private Condition isFull = lock.newCondition();

        public MultiPutBlockQueue(int capacity) {
            this.capacity = capacity;
        }

        @Override
        public Object get() throws Exception {
            lock.lock();

            while (Q.isEmpty()) {
                isEmpty.await();
            }
            Object rslt = Q.poll();
            isFull.signal();

            lock.unlock();
            return rslt;
        }

        @Override
        public void put(Object obj) throws Exception {
            multiput(new LinkedList<>(Arrays.asList(obj)));
        }

        @Override
        public void multiput(List<Object> objs) throws Exception {
            multiPutLock.lock();
            {
                lock.lock();

                for (Object obj : objs) {
                    while (Q.size() == capacity) {
                        isFull.await();
                    }
                    Q.add(obj);
                    isEmpty.signal();
                }

                lock.unlock();
            }
            multiPutLock.unlock();
        }
    }


    class BlockQueue implements BoundBlockQueue {
        private Queue<Object> Q = new LinkedList<>();
        private int capacity;

        public BlockQueue(int capacity) {
            this.capacity = capacity;
        }

        @Override
        public Object get() throws Exception {
            synchronized (Q) {
                while (Q.size() <= 0) {
                    Q.wait();
                }
                Object rslt = Q.poll();
                Q.notifyAll();
                return rslt;
            }
        }

        @Override
        public void put(Object obj) throws Exception {
            synchronized (Q) {
                while (Q.size() >= capacity) {
                    Q.wait();
                }
                Q.add(obj);
                Q.notifyAll();
            }
        }
    }

}