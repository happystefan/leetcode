package Y2018.google;

public class Q028_Implement_strStr_B {

    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i < m - n + 1; i++) {
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) j++;
            if (j == m) return i;
        }
        return -1;
    }

}
