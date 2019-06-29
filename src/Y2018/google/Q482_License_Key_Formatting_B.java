package Y2018.google;

public class Q482_License_Key_Formatting_B {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            if (sb.length() % (K + 1) == K) sb.append('-');
            sb.append(S.charAt(i));
        }
        return sb.reverse().toString().toUpperCase();
    }

}
