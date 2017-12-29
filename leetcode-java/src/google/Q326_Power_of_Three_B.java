package google;

public class Q326_Power_of_Three_B {

    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("10*");
    }

}
