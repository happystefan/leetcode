package linkedin;

public class Q278_First_Bad_Version {

    private boolean isBadVersion(int i) {
        return i % 2 == 0;
    }

    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
