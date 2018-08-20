package archive.Q001_Q300;

/**
 * Created by mingqiangliang on 12/18/17.
 */
public class Q258_Add_Digits {

    public int addDigits(int num) {
        return num == 0 ? 0 : 1+(num-1)%9;
    }

}
