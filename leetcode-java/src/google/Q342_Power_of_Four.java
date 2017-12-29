package google;

public class Q342_Power_of_Four {

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n&(n-1)) == 0 && (n&0x55555555) != 0;
    }

}
