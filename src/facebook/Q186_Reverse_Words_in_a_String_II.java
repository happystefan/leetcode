package facebook;

public class Q186_Reverse_Words_in_a_String_II {

    public void reverseWords(char[] ss) {
        reverse(ss, 0, ss.length - 1);
        int l = 0, r = 0;
        while (r < ss.length) {
            while (l < r || l < ss.length && ss[l] == ' ') l++;
            while (r < l || r < ss.length && ss[r] != ' ') r++;
            reverse(ss, l, r - 1);
        }
    }

    private void reverse(char[] ss, int l, int r) {
        while (l < r) {
            swap(ss, l++, r--);
        }
    }

    private void swap(char[] ss, int i, int j) {
        char tmp = ss[i];
        ss[i] = ss[j];
        ss[j] = tmp;
    }

}
