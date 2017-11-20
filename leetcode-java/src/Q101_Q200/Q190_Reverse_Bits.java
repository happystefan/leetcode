package Q101_Q200;

public class Q190_Reverse_Bits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) | (n &1);
            n >>= 1;
        }
        return ans;
    }

}
