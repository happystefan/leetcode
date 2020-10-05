package Y2020.linkedin.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Q004_Makring_H2O {
    public static void main(String[] args) throws InterruptedException {
        final H2O h2o = new H2O();
        Thread[] h = new Thread[10];
        for (int i = 0; i < 10; i++) {
            h[i] = new Thread("H " + i) {
                @Override
                public void run() {
                    h2o.H();
                }
            };
        }
        Thread[] o = new Thread[5];
        for (int i = 0; i < 5; i++) {
            o[i] = new Thread("O " + i) {
                @Override
                public void run() {
                    h2o.O();
                }
            };
        }
        for (Thread t : h) {
            t.start();

        }
        for (Thread t : o) {
            t.start();
        }

        for (Thread t : h) {

            t.join();
        }
        for (Thread t : o) {

            t.join();
        }
    }


    static class H2O {

        private int numH;
        private int numO;
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition conditionH = lock.newCondition();
        private final Condition conditionO = lock.newCondition();

        public void H() {
            lock.lock();

            try {
                while (numH >= 2) {
                    conditionH.await();
                }
                numH++;
                System.out.println(Thread.currentThread().getName() + " H " + numH);

                createWater();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void O() {
            lock.lock();

            try {
                while (numO >= 1) {
                    conditionO.await();
                }
                numO++;
                System.out.println(Thread.currentThread().getName() + " O " + numO);

                createWater();


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        private boolean createWater() {
            if (numH >= 2 && numO >= 1) {
                numH -= 2;
                numO -= 1;
                System.out.println("create water " + numH + " " + numO);
                conditionH.signal();
                conditionH.signal();
                conditionO.signal();
                return true;
            }
            return false;
        }

    }

    static class MakingH2O {

        private int numH;
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition conditionH = lock.newCondition();

        public void H() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " start " + numH);
            try {
                while (numH >= 2) {
                    conditionH.await();
                }
                numH++;
                conditionH.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " end " + numH);
                lock.unlock();
            }
        }

        public void O() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " start " + numH);
            try {
                while (numH < 2) {
                    conditionH.await();
                }
                numH -= 2;
                conditionH.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " end " + numH);
                lock.unlock();
            }
        }

    }

}