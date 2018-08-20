package archive.google;

public class Q555_Split_Concatenated_Strings {

    public String splitLoopedString(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            strs[i] = max(strs[i], reverse(strs[i]));
        }
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            for (String str : new String[]{strs[i], reverse(strs[i])}) {
                for (int k = 0; k < str.length(); k++) {
                    StringBuilder sb = new StringBuilder(str.substring(k));
                    for (int j = i+1; j < strs.length; j++) sb.append(strs[j]);
                    for (int j = 0; j < i; j++) sb.append(strs[j]);
                    sb.append(str.substring(0, k));
                    result = max(result, sb.toString());
                }
            }
        }
        return result;
    }

    private String max(String a, String b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

}
