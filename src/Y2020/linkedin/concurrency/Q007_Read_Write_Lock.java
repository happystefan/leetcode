package Y2020.linkedin.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q007_Read_Write_Lock {


    interface RWLock {
        void rlock() throws InterruptedException;

        void rUnlock();

        void wlock() throws InterruptedException;

        void wUnlock();
    }

    class MyRWLock {
        private Lock lock = new ReentrantLock();
        private Condition cond = lock.newCondition();
        private int numReaders = 0;

        public void rlock() throws InterruptedException {
            lock.lock();
            numReaders++;
            lock.unlock();
        }

        public void rUnlock() {
            lock.lock();
            numReaders--;
            if (numReaders == 0) {
                cond.signal();
            }
            lock.unlock();
        }

        public void wlock() throws InterruptedException {
            lock.lock();

            while (numReaders > 0) {
                cond.await();
            }
        }

        public void wUnlock() {
            // If there are two writers waiting on the condition variable when readers are present,
            // one of them will take a the lock and the other may still be blocked in Wait.
            // Without additional readers signaling the condition variable, this other writer will
            // be stuck in Wait forever. Therefore it's important for writers to signal the condition
            // variable too, when they're done.
            cond.signal();
            lock.unlock();
        }

    }


    class WriterPreferredLock implements RWLock {

        private Lock lock = new ReentrantLock();
        private Condition cond = lock.newCondition();
        private int numReaders = 0;
        boolean hasWritter = false;

        @Override
        public void rlock() throws InterruptedException {
            lock.lock();

            while (hasWritter) {
                cond.await();
            }
            numReaders++;

            lock.unlock();
        }

        @Override
        public void rUnlock() {
            lock.lock();

            numReaders--;
            if (numReaders == 0) {
                cond.signalAll();
            }

            lock.unlock();
        }

        @Override
        public void wlock() throws InterruptedException {
            lock.lock();

            while (hasWritter) {
                cond.await();
            }
            hasWritter = true;
            while (numReaders > 0) {
                cond.await();
            }

            lock.unlock();
        }

        @Override
        public void wUnlock() {
            lock.lock();

            hasWritter = false;
            cond.signalAll();

            lock.unlock();
        }
    }

    class ReaderPreferredLock implements RWLock {

        @Override
        public void rlock() {

        }

        @Override
        public void rUnlock() {

        }

        @Override
        public void wlock() {

        }

        @Override
        public void wUnlock() {

        }
    }

}
