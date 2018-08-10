package facebook;

public class Q670_Maximum_Swap {

    public int maximumSwap(int num) {
        char[] ss = String.valueOf(num).toCharArray();
        int[] index = new int[10];
        for (int i = 0; i < ss.length; i++) {
            index[ss[i]-'0'] = i;
        }
        for (int i = 0; i < ss.length; i++) {
            for (int j = 9; j > ss[i]-'0'; j--) {
                if (index[j] > i) {
                    char tmp = ss[i];
                    ss[i] = ss[index[j]];
                    ss[index[j]] = tmp;
                    return Integer.valueOf(new String(ss));
                }
            }
        }
        return num;
    }

}
