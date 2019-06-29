package Y2018.Q001_Q300;

public class Q172_Factorial_Trailing_Zeroes {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}
