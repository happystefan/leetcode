package Y2020.linkedin.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Q001_Producer_Consumer {

    public static void main(String[] args) {
        Queue<Integer> Q = new LinkedList<>();

        Thread producer = new Thread(new Producer(Q, 50, 100));
        Thread consumer = new Thread(new Consumer(Q));

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static class Producer implements Runnable {
        private final Queue<Integer> Q;
        private final int size;
        private final int K;
        boolean shutdown = false;

        public Producer(Queue<Integer> Q, int size, int K) {
            this.Q = Q;
            this.size = size;
            this.K = K;
        }

        @Override
        public void run() {
            for (int i = 0; i < K && !shutdown; i++) {
                produce(i);
                try {
                    Thread.sleep(1000 * new Random().nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            if (shutdown) {
                throw new IllegalStateException("already shut down");
            }
            shutdown = true;
        }

        private void produce(int item) {
            synchronized (Q) {
                while (Q.size() >= size) {
                    try {
                        Q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Q.add(item);
                System.out.println(Thread.currentThread().getName() + " produce " + item);
                Q.notifyAll();
            }
        }
    }

    static class Consumer implements Runnable {
        private final Queue<Integer> Q;
        private final boolean shutdown = false;

        public Consumer(Queue<Integer> Q) {
            this.Q = Q;
        }

        @Override
        public void run() {
            while (!shutdown) {
                int item = consume();
                try {
                    Thread.sleep(1000 * new Random().nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private int consume() {
            synchronized (Q) {
                while (Q.isEmpty()) {
                    try {
                        Q.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int rslt = Q.remove();
                System.out.println(Thread.currentThread().getName() + " consume " + rslt);
                Q.notifyAll();
                return rslt;
            }
        }
    }

}