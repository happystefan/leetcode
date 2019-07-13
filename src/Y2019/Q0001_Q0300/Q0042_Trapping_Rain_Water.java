package Y2019.Q0001_Q0300;

public class Q0042_Trapping_Rain_Water {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int result = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                lmax = Math.max(lmax, height[l]);
                result += lmax - height[l];
                l++;
            } else {
                rmax = Math.max(rmax, height[r]);
                result += rmax - height[r];
                r--;
            }
        }
        return result;
    }

}
