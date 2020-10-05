package Y2020.linkedin.algo_part2;


public class Q025_BitSet_Implementation {

    class BitSetImpl {
        byte[] arr;
        int size = 0;

        public BitSetImpl(int size) {
            arr = new byte[size / 8 + 1];
            this.size = size;
        }

        public void set(int n) {
            if (n > size) {
                throw new IllegalStateException();
            }
            int arryIdx = n / 8;
            int byteIdx = n % 8;
            byte mask = (byte) (1 << byteIdx);
            arr[arryIdx] |= mask;
        }

        public void clear(int n) {
            if (n > size) {
                throw new IllegalStateException();
            }
            int arryIdx = n / 8;
            int byteIdx = n % 8;
            byte mask = ((byte) (~(1 << byteIdx)));
            arr[arryIdx] &= mask;
        }

        public boolean isSet(int n) {
            if (n > size) {
                throw new IllegalStateException();
            }
            int arryIdx = n / 8;
            int byteIdx = n % 8;
            byte mask = (byte) (1 << byteIdx);
            return (arr[arryIdx] & mask) == (byte) 0;

        }
    }

}
