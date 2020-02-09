package Y2019.facebook;

public class Q0767_Reorganize_String {

    public String reorganizeString(String S) {
        int[] cnt = new int[26];
        int[] nxt = new int[26];
        for (char c : S.toCharArray()) cnt[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int candidate = find(cnt, nxt, i);
            if (candidate == -1) return "";
            sb.append((char) (candidate + 'a'));
            cnt[candidate]--;
            nxt[candidate] = i + 2;
        }
        return sb.toString();
    }

    private int find(int[] cnt, int[] nxt, int cur) {
        int max = Integer.MIN_VALUE;
        int candidate = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] > max && nxt[i] <= cur) {
                candidate = i;
                max = cnt[i];
            }
        }
        return candidate;
    }

}
