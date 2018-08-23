package facebook;

import java.util.*;

public class Q158_Read_N_Characters_Given_Read4_II_Call_multiple_times {

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
        ArrayDeque<Character> remaining = new ArrayDeque<>();
        public int read(char[] buf, int n) {
            int k = 0;
            while (k < n && !remaining.isEmpty()) {
                buf[k++] = remaining.pollFirst();
            }
            if (k == n) return k;
            char[] tmp = new char[4];
            while (true) {
                int cnt = read4(tmp);
                if (cnt == 0) break;
                int i = 0;
                while (k < n && i < cnt) {
                    buf[k++] = tmp[i++];
                }
                if (k == n) {
                    while (i < cnt) {
                        remaining.addLast(tmp[i++]);
                    }
                    break;
                }
            }
            return k;
        }
    }

}
