package google;

/**
 * Created by mingqiangliang on 12/26/17.
 */
public class Q729_Last_Digit_By_Factorial_Divide {

    public int computeLastDigit(long A, long B) {
        // write your code here
        long ans = 1;
        for (long i = A+1; i <= B; i++) {
            ans = (ans*i)%10;
            if (ans == 0) break;
        }
        return (int)ans;
    }

}
