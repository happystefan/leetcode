package Y2020.facebook.misc;

public class Q0042_Trapping_Rain_Water {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int rslt = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > lmax) lmax = height[l];
                else rslt += height[l] - lmax;
                l++;
            } else {
                if (height[r] > rmax) rmax = height[r];
                else rslt += height[r] - rmax;
                r--;
            }
        }
        return rslt;
    }

}
