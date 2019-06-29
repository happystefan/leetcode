package Q001_Q300;

public class Q171_Excel_Sheet_Column_Number {

    public int titleToNumber(String s) {
        char[] ss = s.toCharArray();
        int ans = 0;
        int scale = 1;
        for (int i = ss.length - 1; i >= 0; i--) {
            ans += (ss[i] - 'A' + 1) * scale;
            scale *= 26;
        }
        return ans;
    }

}
