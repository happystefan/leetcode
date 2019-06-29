package Y2018.google;

public class Q231_Power_of_Two_B {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
