package Q001_Q100;

/**
 * Created by mqliang on 5/27/17.
 */
public class Q007_Reverse_Integer {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            x = -x;
            sign = -1;
        }
        long y = 0;
        while(x != 0) {
            y = y*10 + x%10;
            x /= 10;
            if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return sign*(int)y;
    }
}
