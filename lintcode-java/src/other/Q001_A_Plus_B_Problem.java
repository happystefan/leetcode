package other;

/**
 * Created by mingqiangliang on 12/21/17.
 */
public class Q001_A_Plus_B_Problem {

    public int aplusb(int a, int b) {
        while (b != 0) {
            int aa = a^b;
            int bb = (a&b)<<1;
            a = aa;
            b = bb;
        }
        return a;
    }

}
