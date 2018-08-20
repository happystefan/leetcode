package archive.google;


public class Q482_License_Key_Formatting {

    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        System.out.println(S);
        int first = S.length()%K;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) c = Character.toUpperCase(c);
            sb.append(c);
            if ((i+1-first)%K == 0 && i+1 != S.length()) sb.append('-');
        }
        return sb.toString();
    }

}
