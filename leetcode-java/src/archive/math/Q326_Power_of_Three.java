package archive.math;

public class Q326_Power_of_Three {

    public boolean isPowerOfThree(int n) {
        String str = Integer.toString(n, 3);
        if (str.length() == 0) {
            return false;
        }
        if (str.charAt(0) != '1') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

}
