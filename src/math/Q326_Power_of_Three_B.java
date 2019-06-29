package math;

public class Q326_Power_of_Three_B {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        return 1162261467 % n == 0;
    }
}
