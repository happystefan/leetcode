package google;

public class Q316_Remove_Duplicate_Letters {

    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c-'a']++;
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (cnt[s.charAt(i)-'a'] == 1) break;
            cnt[s.charAt(i)-'a']--;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos+1).replaceAll(""+s.charAt(pos), ""));
    }

}
