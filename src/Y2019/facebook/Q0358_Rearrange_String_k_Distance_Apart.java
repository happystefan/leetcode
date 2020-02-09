package Y2019.facebook;


public class Q0358_Rearrange_String_k_Distance_Apart {

    public String rearrangeString(String s, int k) {
        int[] cnt = new int[26];
        int[] nxt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int candidate = find(cnt, nxt, i);
            if (candidate == -1) return "";
            cnt[candidate]--;
            nxt[candidate] = i + k;
            sb.append((char) (candidate + 'a'));
        }
        return sb.toString();
    }

    private int find(int[] cnt, int[] nxt, int cur) {
        int max = Integer.MIN_VALUE;
        int candidate = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] > max && nxt[i] <= cur) {
                max = cnt[i];
                candidate = i;
            }
        }
        return candidate;
    }

}
