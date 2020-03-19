package Y2020.facebook;

public class Q0263_Ugly_Number {

    public boolean isUgly(int num) {
        if (num == 0) return false;
        while (num != 1) {
            if (num % 2 == 0) num /= 2;
            else if (num % 3 == 0) num /= 3;
            else if (num % 5 == 0) num /= 5;
            else return false;
        }
        return true;
    }

}
