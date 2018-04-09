package facebook;

public class Q013_strStr_B {
    // KMP algorithm
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }

        int sLen = source.length(), tLen = target.length();
        int[] next = getNext(target);

        for (int i = 0, j = 0; i < sLen; i++) {
            while (j > 0 && source.charAt(i) != target.charAt(j)) {
                j = next[j-1];
            }
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
            if (j == tLen) {
                return i-j+1;
            }
        }
        return -1;
    }

    private int[] getNext(String target) {
        int[] next = new int[target.length()];
        next[0] = 0;
        for (int j = 1, k = 0; j < target.length(); j++) {
            while (k > 0 && target.charAt(j) != target.charAt(k)) {
                k = next[k-1];
            }
            if (target.charAt(j) == target.charAt(k)) {
                k++;
            }
            next[j] = k;
        }
        return next;
    }

}
