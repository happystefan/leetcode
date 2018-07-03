package Q001_Q300;

/**
 * Created by mingqiangliang on 12/19/17.
 */
public class Q263_Ugly_Number {

    public boolean isUgly(int num) {
        if (num == 0) return false;
        while (num != 1) {
            if (num%2 == 0) num /= 2;
            else if (num%3 == 0) num /= 3;
            else if (num%5 == 0) num /= 5;
            else return false;
        }
        return true;
    }

}
