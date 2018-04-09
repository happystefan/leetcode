package facebook;

public class Q013_strStr {

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int sLen = source.length(), tLen = target.length();
        int i = 0, j = 0;
        while (i < sLen && j < tLen) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == target.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

}
