package archive.google;

public class Q231_Power_of_Two_C {

    public boolean isPowerOfTwo(int n) {
        return Integer.toString(n, 2).matches("10*");
    }

}
