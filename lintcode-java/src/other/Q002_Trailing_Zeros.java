package other;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q002_Trailing_Zeros {

    public long trailingZeros(long n) {
        long ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }

}
