package Y2019.Q0301_Q0600;

public class Q0357_Count_Numbers_with_Unique_Digits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        if (n > 11) n = 10;
        int result = 9;
        for (int i = 9 - n + 2; i <= 9; i++) result *= i;
        return result + countNumbersWithUniqueDigits(n - 1);
    }

}
