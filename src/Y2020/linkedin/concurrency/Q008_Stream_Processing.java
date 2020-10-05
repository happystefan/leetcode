package Y2020.linkedin.concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* Optimization:
    * Fix size window. [1:00,2:00], [2:00, 3:00]. When GC, may discard a whole
    * slot, instead of traverse all records in that slot one by one
*/
public class Q008_Stream_Processing {

    static class SlidingWindow {
        private final Map<Long, Msg> map = new ConcurrentHashMap<>();
        Queue<long[]> list = new ConcurrentLinkedQueue<>();
        private long nMicroecs = 0;
        private double sum = 0;

        ReadWriteLock listHeadLock = new ReentrantReadWriteLock();
        ReadWriteLock listTailLock = new ReentrantReadWriteLock();
        ReadWriteLock sumLock = new ReentrantReadWriteLock();

        public SlidingWindow(int nMicroecs) {
            this.nMicroecs = nMicroecs;
        }

        public void addMsg(Msg m) {
            long currentTime = System.currentTimeMillis() * 1000;
            gc(currentTime);

            list.add(new long[]{m.key, currentTime});
            map.put(m.key, m);
            sum += m.val;
        }

        public Msg getMsg(long key) {
            long currentTime = System.currentTimeMillis() * 1000;
            gc(currentTime);

            if (map.containsKey(key)) return map.get(key);
            return null;
        }

        public Double getAve() {
            long currentTime = System.currentTimeMillis() * 1000;
            gc(currentTime);

            if (map.isEmpty()) return -1.0;
            return sum / map.size();
        }

        private void gc(long currentTime) {
            Iterator<long[]> it = list.iterator();
            while (it.hasNext()) {
                long[] pair = it.next();
                if (pair[1] + nMicroecs <= currentTime) {
                    it.remove();
                    sum -= map.get(pair[0]).val;
                    map.remove(pair[0]);
                } else {
                    break;
                }
            }
        }
    }

    static class Msg {
        long key;
        long val;
    }

}