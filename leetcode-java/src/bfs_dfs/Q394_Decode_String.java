package bfs_dfs;

public class Q394_Decode_String {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && s.charAt(j) != '[') {
                    j++;
                }
                int num = Integer.valueOf(s.substring(i, j));
                i = j;
                j++;
                int cnt = 1;
                while (j < s.length() && cnt != 0) {
                    if (s.charAt(j) == '[') cnt++;
                    if (s.charAt(j) == ']') cnt--;
                    j++;
                }
                String str = decodeString(s.substring(i+1, j-1));
                while (num-- > 0) {
                    sb.append(str);
                }
                i = j-1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
