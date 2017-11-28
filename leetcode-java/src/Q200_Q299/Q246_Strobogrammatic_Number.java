package Q200_Q299;

public class Q246_Strobogrammatic_Number {

    public boolean isStrobogrammatic(String num) {
        char[] f = num.toCharArray();
        if (f.length%2 == 1) {
            if (f[f.length/2] != '1' && f[f.length/2] != '8') return false;
        }
        int i = 0, j = f.length-1;
        while (i < j ) {
            if (!(f[i] == f[j] && (f[i] == '1' || f[i] == '8') ||
                    f[i] == '6' && f[j] == '9' || f[i] == '9' || f[j] == '6')) {
                return false;
            }
        }
        return true;
    }

}
