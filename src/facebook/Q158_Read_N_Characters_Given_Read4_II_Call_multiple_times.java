package facebook;

import java.util.LinkedList;
import java.util.List;

public class Q158_Read_N_Characters_Given_Read4_II_Call_multiple_times {

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
        List<Character> remain = new LinkedList<>();

        public int read(char[] buf, int n) {
            int k = 0;
            int result = 0;
            while (true) {
                char[] tmp = new char[4];
                while (remain.size() != 0 && k < n) {
                    buf[k++] = remain.get(0);
                    result++;
                    remain.remove(0);
                }
                if (k == n) {
                    break;
                }

                int cnt = read4(tmp);
                if (cnt == 0) {
                    break;
                }
                int i = 0;
                for (; i < cnt && k < n; i++) {
                    buf[k++] = tmp[i];
                    result++;
                }
                if (k == n) {
                    for (; i < cnt; i++) {
                        remain.add(tmp[i]);
                    }
                    break;
                }
            }
            return result;
        }
    }

}
