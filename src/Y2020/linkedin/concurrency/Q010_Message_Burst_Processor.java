package Y2020.linkedin.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q010_Message_Burst_Processor {

    class MessageBurstProcessor {
        private final long quietPeriod;
        private final Lock lock = new ReentrantLock();
        private final Condition cond = lock.newCondition();

        public MessageBurstProcessor(long quietPeriod) {
            this.quietPeriod = quietPeriod;
        }

        public boolean process(Object msg) throws Exception {
            lock.lock();
            try {
                cond.signal();
                return !cond.await(this.quietPeriod, TimeUnit.MILLISECONDS);
            } finally {
                lock.unlock();
            }
        }
    }

    class MessageBurstProcessorLastN {
        private final long quietPeriod;
        private final int num;
        private final Lock lock = new ReentrantLock();
        private final Condition[] conds;

        public MessageBurstProcessorLastN(long quietPeriod, int num) {
            this.quietPeriod = quietPeriod;
            this.num = num;
            this.conds = new Condition[num];
            for (int i = 0; i < num; i++) {
                this.conds[i] = lock.newCondition();
            }
        }

        public boolean process(Object msg) throws Exception {
            lock.lock();
            try {
                for (Condition cond : conds) {
                    cond.signal();
                    if (!cond.await(this.quietPeriod, TimeUnit.MILLISECONDS)) {
                        return true;
                    }
                }
                return false;
            } finally {
                lock.unlock();
            }
        }
    }

}
