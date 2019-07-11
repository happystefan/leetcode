package Y2019.sliding_window;

public class Q0028_Implement_strStr {

    public int strStr(String haystk, String needle) {
        if (haystk == null || needle == null) return -1;
        int m = haystk.length(), n = needle.length();
        if (m < n) return -1;
        if (n == 0) return 0;

        int mod = Integer.MAX_VALUE / 53;
        int m52 = 1;
        for (int i = 0; i < n - 1; i++) {
            m52 = (m52 * 52) % mod;
        }

        int target_hash = 0;
        for (int i = 0; i < n; i++) {
            target_hash = target_hash * 52 + (needle.charAt(i) - 'A');
            target_hash %= mod;
        }

        int l = 0, r = 0;
        int window_hash = 0;
        while (r < m) {
            if (r - l + 1 <= n) {
                window_hash = window_hash * 52 + (haystk.charAt(r++) - 'A');
                window_hash %= mod;
            } else {
                window_hash -= (haystk.charAt(l++) - 'A') * m52;
                window_hash %= mod;
            }
            if (r - l == n && haystk.substring(l, l + n).equals(needle)) return l;
        }

        return -1;
    }

}
