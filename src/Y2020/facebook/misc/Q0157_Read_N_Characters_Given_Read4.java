package Y2020.facebook.misc;

public class Q0157_Read_N_Characters_Given_Read4 {

    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf);
     */
    class Reader4 {
        int read4(char[] buf) {
            return 0;
        }
    }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return The number of actual characters read
         */
        String str = "";

        public int read(char[] buf, int n) {
            while (str.length() < n) {
                char[] tmp = new char[4];
                int i = read4(tmp);
                for (int j = 0; j < i; j++) str += tmp[j];
                if (i < 4) break;
            }
            int i;
            for (i = 0; i < Math.min(str.length(), n); i++) {
                buf[i] = str.charAt(i);
            }
            str = str.substring(i);
            return i;
        }

    }

}
