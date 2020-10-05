package Y2020.linkedin.concurrency;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Q005_Delayed_Scheduler {

    interface DelayerScheduler {
        void delayRun(long delayTime, Runnable task);
    }

    class Scheduler implements DelayerScheduler {

        PriorityQueue<Task> Q = new PriorityQueue<Task>((a, b) -> (int) (a.time - b.time));
        Lock lock = new ReentrantLock();
        Condition cond = lock.newCondition();

        public Scheduler() {
            Thread t = new Thread("background") {
                @Override
                public void run() {
                    while (true) {
                        try {
                            lock.lock();
                            while (Q.isEmpty()) {
                                cond.await();
                            }
                            Task task = Q.peek();
                            long current = System.currentTimeMillis();
                            if (task.time <= current) {
                                task.task.run();
                                Q.poll();
                            } else {
                                cond.await(task.time - current, TimeUnit.MILLISECONDS);
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    }
                }
            };
            t.start();
        }

        @Override
        public void delayRun(long delayTime, Runnable task) {
            lock.lock();

            Q.add(new Task(System.currentTimeMillis() + delayTime, task));
            cond.signal();

            lock.unlock();
        }

    }

    class Task {
        long time;
        Runnable task;

        public Task(long time, Runnable task) {
            this.time = time;
            this.task = task;
        }
    }

}