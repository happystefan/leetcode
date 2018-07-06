package dp;

public class Q357_Count_Numbers_with_Unique_Digits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += count(i);
        }
        return result;
    }

    private int count(int n) {
        if (n == 1) {
            return 10;
        }
        if (n > 10) {
            return 0;
        }
        int result = 9;
        int cnt = 9;
        for (int i = 1; i < n; i++) {
            result *= cnt;
            cnt--;
        }
        return result;
    }

}
