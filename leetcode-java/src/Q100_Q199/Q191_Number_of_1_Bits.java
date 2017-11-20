package Q100_Q199;

public class Q191_Number_of_1_Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) ans++;
            n >>= 1;
        }
        return ans;
    }

}
