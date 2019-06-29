package facebook;

public class Q151_Reverse_Words_in_a_String_B {

    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        reverse(ss, 0, ss.length - 1);

        int l = 0, r = 0;
        while (l < ss.length) {
            while (l < r || l < ss.length && ss[l] == ' ') l++;
            while (r < l || r < ss.length && ss[r] != ' ') r++;
            reverse(ss, l, r - 1);
        }
        int k = 0, i = 0;
        while (i < ss.length) {
            while (i < ss.length && ss[i] == ' ') i++;
            while (i < ss.length && ss[i] != ' ') ss[k++] = ss[i++];
            while (i < ss.length && ss[i] == ' ') i++;
            if (i < ss.length) ss[k++] = ' ';
        }
        return new String(ss).substring(0, k);
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
