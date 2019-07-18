package Y2019.Q0001_Q0300;

public class Q0066_Plus_One {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int c = 1;
        for (int i = n - 1; i >= 0; i--) {
            int sum = c + digits[i];
            digits[i] = sum % 10;
            c = sum / 10;
            if (c == 0) return digits;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

}
