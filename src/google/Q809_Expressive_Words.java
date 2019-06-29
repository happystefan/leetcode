package google;

public class Q809_Expressive_Words {

    public int expressiveWords(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            if (isStretchy(S.toCharArray(), word.toCharArray())) {
                result++;
            }
        }
        return result;
    }

    private boolean isStretchy(char[] stretch, char[] origin) {
        int i = 0, j = 0;
        for (i = 0; i < stretch.length; i++) {
            if (j < origin.length && stretch[i] == origin[j]) {
                j++;
            } else if (i > 0 && stretch[i - 1] == stretch[i] && i + 1 < stretch.length && stretch[i + 1] == stretch[i]) {
                i++;
            } else if (!(i > 1 && stretch[i - 1] == stretch[i] && stretch[i - 2] == stretch[i])) {
                break;
            }
        }
        return i == stretch.length && j == origin.length;
    }

}
