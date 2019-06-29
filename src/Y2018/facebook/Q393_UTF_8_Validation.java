package Y2018.facebook;

public class Q393_UTF_8_Validation {

    public boolean validUtf8(int[] data) {
        int mask1 = 0b10000000;
        int mask2 = 0b11100000;
        int mask3 = 0b11110000;
        int mask4 = 0b11111000;
        int mask5 = 0b11000000;
        for (int i = 0; i < data.length; i++) {
            int cnt = 0;
            if ((data[i] & mask1) == 0b00000000) {
                cnt = 0;
            } else if ((data[i] & mask2) == 0b11000000) {
                cnt = 1;
            } else if ((data[i] & mask3) == 0b11100000) {
                cnt = 2;
            } else if ((data[i] & mask4) == 0b11110000) {
                cnt = 3;
            } else {
                return false;
            }
            while (cnt-- > 0) {
                if (i + 1 >= data.length || (data[i + 1] & mask5) != 0b10000000) {
                    return false;
                } else {
                    i++;
                }
            }
        }
        return true;
    }

}
