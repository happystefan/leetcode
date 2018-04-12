package facebook;

class SVNRepo {
    public static boolean isBadVersion(int k) {
        return false;
    }
}

public class Q074_First_Bad_Version {

    public int findFirstBadVersion(int n) {
        int l = 0, r = n;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (SVNRepo.isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
