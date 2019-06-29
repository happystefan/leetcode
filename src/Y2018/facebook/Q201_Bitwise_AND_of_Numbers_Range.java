package Y2018.facebook;

public class Q201_Bitwise_AND_of_Numbers_Range {

    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            cnt += 1;
        }
        return m << cnt;
    }

}
