package Q101_Q200;

public class Q168_Excel_Sheet_Column_Title {

    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n != 0) {
            ans.insert(0, (char)('A'+n%26-1));
            n /= 26;
        }
        return ans.toString();
    }

}
