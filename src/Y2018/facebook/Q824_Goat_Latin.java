package Y2018.facebook;

public class Q824_Goat_Latin {

    public String toGoatLatin(String S) {
        String[] ss = S.trim().split("\\s+");
        String suffix = "a";
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            if (beginWithVowel(s)) {
                s = s + "ma";
            } else {
                char first = s.charAt(0);
                s = s.substring(1);
                s = s + first + "ma";
            }
            s += suffix;
            ss[i] = s;
            suffix += "a";
        }
        return String.join(" ", ss);
    }

    private boolean beginWithVowel(String s) {
        char c = Character.toLowerCase(s.charAt(0));
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
