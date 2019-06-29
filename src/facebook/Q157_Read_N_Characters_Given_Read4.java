package facebook;

public class Q157_Read_N_Characters_Given_Read4 {

    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    class Reader4 {
        public int read4(char[] buf) {
            return 4;
        }
    }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return The number of characters read
         */
        public int read(char[] buf, int n) {
            int k = 0;
            int result = 0;
            while (true) {
                char[] tmp = new char[4];
                int cnt = read4(tmp);
                if (cnt == 0) {
                    break;
                }
                for (int i = 0; i < cnt && k < n; i++) {
                    buf[k++] = tmp[i];
                    result++;
                }
                if (k == n) {
                    break;
                }
            }
            return result;
        }

    }

}
