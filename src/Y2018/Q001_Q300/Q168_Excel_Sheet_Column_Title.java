package Y2018.Q001_Q300;

public class Q168_Excel_Sheet_Column_Title {

    public String convertToTitle(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            n--;
            ans.insert(0, (char) ((int) 'A' + n % 26));
            n /= 26;
        }
        return ans.toString();
    }

}
