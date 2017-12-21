package google;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q407_Plus_One {

    public int[] plusOne(int[] digits) {
        int c = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int nc = (digits[i]+c)/10;
            digits[i] = (digits[i]+c)%10;
            c = nc;
            if (c == 0) return digits;
        }
        int[] ans = new int[digits.length+1];
        ans[0] = 1;
        System.arraycopy(digits, 0, ans, 1, digits.length);
        return ans;
    }

}
