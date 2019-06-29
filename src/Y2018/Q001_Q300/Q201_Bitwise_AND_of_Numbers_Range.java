package Y2018.Q001_Q300;

public class Q201_Bitwise_AND_of_Numbers_Range {

    public int rangeBitwiseAnd(int m, int n) {
        int r = Integer.MAX_VALUE;
        while ((r & m) != (r & n)) r <<= 1;
        return r & n;
    }

}
