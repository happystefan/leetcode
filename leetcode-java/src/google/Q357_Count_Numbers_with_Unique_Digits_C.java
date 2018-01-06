package google;

public class Q357_Count_Numbers_with_Unique_Digits_C {

    public int countNumbersWithUniqueDigits(int n) {
        int[] f = new int[11];
        f[0] = 1; f[1] = 9;
        for (int i = 2; i < 11; i++) {
            f[i] = f[i-1]*(11-i);
        }
        for (int i = 1; i < 11; i++) {
            f[i] += f[i-1];
        }
        return f[n > 10 ? 10 : n];
    }

}
