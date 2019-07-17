package Y2019.Q0001_Q0300;

public class Q0058_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i++) {
            if (s.charAt(i) == ' ') {
                if (result > 0) break;
            } else {
                result++;
            }
        }
        return result;
    }

}
