package Y2020.linkedin.algo_part1;

import java.util.Arrays;
import java.util.LinkedList;

public class Q021_File_System {

    class Buffer extends pBuffer {

        // [0, FIRST_BLOCK) blocks are used for metadata, other blocks are used for payload
        private final int FIRST_BLOCK = (BLOCK_CNT / (BLOCK_SIZE * 8)) + 1;
        private final LinkedList<Integer> free = new LinkedList<>();

        private boolean isMarked(int idx) {
            int byteIdx = idx / 8;
            int bitIdx = idx % 8;
            return (buffer[byteIdx] & (1 << bitIdx)) != 0;
        }

        private void mark(int idx) {
            int byteIdx = idx / 8;
            int bitIdx = idx % 8;
            buffer[byteIdx] |= 1 << bitIdx;
        }

        private void unmark(int idx) {
            int byteIdx = idx / 8;
            int bitIdx = idx % 8;
            buffer[byteIdx] &= ~(1 << bitIdx);
        }

        public Buffer() {
            super();
            for (int i = FIRST_BLOCK; i <= BLOCK_CNT; i++) {
                if (!isMarked(i)) free.add(i);
            }
        }

        @Override
        public Location create() throws Exception {
            if (free.isEmpty()) {
                throw new Exception();
            }
            int idx = free.removeFirst();
            mark(idx);
            return new Location(idx);
        }

        @Override
        public void put(Location l, byte[] data) {
            if (data == null || data.length == 0) return;
            int idx = l.GetLocation();
            if (idx >= BLOCK_CNT || idx < FIRST_BLOCK || isMarked(idx)) {
                return;
            }
            System.arraycopy(data, 0, buffer, idx * BLOCK_SIZE, Math.min(BLOCK_SIZE, data.length));
            mark(idx);
        }

        @Override
        public byte[] get(Location l) {
            int idx = l.GetLocation();
            if (idx >= BLOCK_CNT || idx < FIRST_BLOCK || isMarked(idx)) {
                return null;
            }
            return Arrays.copyOfRange(buffer, idx * BLOCK_SIZE, idx * BLOCK_SIZE + BLOCK_SIZE);
        }

        @Override
        public void free(Location l) {
            int idx = l.GetLocation();
            if (idx >= BLOCK_CNT || idx < FIRST_BLOCK || isMarked(idx)) {
                return;
            }
            unmark(idx);
            // don't clear the underlying buffer/disk, overwrite them when next put.
            // meta-data already marks them as un-used, so them will been treat as garbage
            free.add(idx);
        }


    }


    class Location {
        private final int index;

        public Location(int index) {
            this.index = index;
        }

        public int GetLocation() {
            return this.index;
        }
    }

    abstract class pBuffer {
        protected final int BLOCK_SIZE = 1024;
        protected final int BLOCK_CNT = 1024;
        protected byte[] buffer = new byte[BLOCK_CNT * BLOCK_SIZE];

        public pBuffer() {
            // fillBufferFromFile();
        }

        public abstract Location create() throws Exception;

        public abstract void put(Location l, byte[] data);

        public abstract byte[] get(Location l);

        public abstract void free(Location l);

        private void onShutDown() {
            // writeBufferToFile();
        }
    }

}