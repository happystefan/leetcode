package Y2018.google;

public class Q342_Power_of_Four_B {

    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }

}
