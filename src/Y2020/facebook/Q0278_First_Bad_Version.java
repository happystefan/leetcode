package Y2020.facebook;

public class Q0278_First_Bad_Version {

    boolean isBadVersion(int version) {
        return false;
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
