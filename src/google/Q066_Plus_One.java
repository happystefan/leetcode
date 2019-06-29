package google;

public class Q066_Plus_One {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int ncarry = (digits[i] + carry) / 10;
            digits[i] = (digits[i] + carry) % 10;
            carry = ncarry;
            if (carry == 0) return digits;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            ans[i + 1] = digits[i];
        }
        return ans;
    }

}
