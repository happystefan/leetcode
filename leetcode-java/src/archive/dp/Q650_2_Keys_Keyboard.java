package archive.dp;

public class Q650_2_Keys_Keyboard {

    public int minSteps(int n) {
        int result = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                result += d;
                n /= d;
            }
            d++;
        }
        return result;
    }

}
