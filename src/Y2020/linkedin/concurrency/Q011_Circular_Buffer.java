package Y2020.linkedin.concurrency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q011_Circular_Buffer {

    class CircularBuffer {
        byte[] buffer;
        // seq->offset
        Map<Integer, Integer> map = new HashMap<>();
        int capacity;
        int head = 0;

        public CircularBuffer(int capacity) {
            this.capacity = capacity;
            buffer = new byte[capacity];
        }

        public void addRecord(int seq, byte[] data) {
            if (data.length > capacity) {
                throw new IllegalArgumentException();
            }
            map.put(seq, head);
            if (head + data.length <= capacity) {
                System.arraycopy(data, 0, buffer, head, data.length);

                int l = head, r = head + data.length;
                map.entrySet().removeIf(entry -> (entry.getKey() >= l + 1 && entry.getKey() < r));

                head = r;
            } else {
                System.arraycopy(data, 0, buffer, head, capacity - head);
                System.arraycopy(data, 0, buffer, 0, (head + data.length) % capacity);

                int l = head, r = capacity;
                int ll = 0, rr = (head + data.length) % capacity;
                map.entrySet().removeIf(
                        entry -> (entry.getKey() >= l + 1 && entry.getKey() < r ||
                                entry.getKey() >= ll && entry.getKey() < r)
                );
                head = rr;
            }
        }

        private byte[] getRecord(int seq, int length) {
            if (length > capacity) {
                throw new IllegalArgumentException();
            }
            if (!map.containsKey(seq)) {
                throw new IllegalArgumentException("seq number not exist or has been overwritten by new data");
            }
            if (map.get(seq) + length <= capacity) {
                return Arrays.copyOfRange(buffer, map.get(seq), length);
            } else {
                byte[] rslt = new byte[map.get(seq)];
                System.arraycopy(buffer, map.get(seq), rslt, 0, capacity - map.get(seq));
                System.arraycopy(buffer, 0, rslt, capacity - map.get(seq), length - (capacity - map.get(seq)));
                return rslt;
            }
        }

    }

}
