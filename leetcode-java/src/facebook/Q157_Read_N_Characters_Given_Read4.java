package facebook;

public class Q157_Read_N_Characters_Given_Read4 {

    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
    class Reader4 {
        int read4(char[] buf) {
            return 0;
        }
    }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */
        public int read(char[] buf, int n) {
            int k = 0;
            char[] tmp = new char[4];
            while (true) {
                int cnt = read4(tmp);
                if (cnt == 0) {
                    break;
                }
                int i = 0;
                while (k < n && i < cnt) {
                    buf[k++] = tmp[i++];
                }
                if (k == n) break;
            }
            return k;
        }
    }

}
